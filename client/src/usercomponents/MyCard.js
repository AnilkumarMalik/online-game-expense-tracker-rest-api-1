import {
  Button,
  Card,
  CardActions,
  CardContent,
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  DialogTitle,
  Grid,
  Typography,
} from "@mui/material";
import React from "react";
import { getMatchDetail } from "../api/Api";
import { useState } from "react";
import { Fragment } from "react";

const MyCard = ({ match }) => {
  const [detail, setDetail] = useState({});

  const [open, setOpen] = useState(false);

  const handleClick = (id) => {
    getMatchDetail(id)
      .then((data) => {
        console.log("MATCH DATA", data);
        setDetail(data);

        handleOpen();
      })
      .catch((error) => console.log(error));
  };
  const getMatchCard = () => {
    return (
      <Card style={{ marginTop: 15 }}>
        <CardContent>
          <Grid
            container
            justifyContent={"center"}
            alignContent={"center"}
            spacing={4}
          >
            <Grid item>
              <Typography variant="h5">{match["t-1"]}</Typography>
            </Grid>
            <Grid item>
              <img
                style={{ width: 75 }}
                src={require("../img/vs.png")}
                alt=""
              />
            </Grid>
            <Grid item>
              <Typography variant="h5"> {match["t-2"]} </Typography>
            </Grid>
          </Grid>
        </CardContent>
        <CardActions>
          <Grid container justifyContent={"center"}>
            <Button
              onClick={() => {
                handleClick(match.unique_id);
              }}
              item
              variant="contained"
              color="primary"
            >
              Show Detail
            </Button>
            <Button
              style={{ marginLeft: 5 }}
              item
              variant="contained"
              color="primary"
            >
              Start Time{new Date(match.dateTimeGMT).toLocaleString()}
            </Button>
          </Grid>
        </CardActions>
      </Card>
    );
  };


  const handleClose=()=>{
    setOpen(false);
  }

  const handleOpen=()=>{
setOpen(true);
  }

  const getDialog = () => (
    <Dialog open={open} onClose={handleClose}>
      <DialogTitle id="alert-dialog-tittle">{"Match Detail...."}</DialogTitle>
      <DialogContent>
        <DialogContentText id="alert-dialog-description">
          <Typography>{detail.stat}</Typography>
          <Typography>
            Match{" "}
            <span style={{ fontStyle: "italic", fontWeight: "bold" }}>
              {detail.matchStarted ? "Started" : "Still not started"}{" "}
            </span>
          </Typography>
          <Typography>
            Score{" "}
            <span style={{ fontStyle: "italic", fontWeight: "bold" }}>
              {detail.score}{" "}
            </span>
          </Typography>
        </DialogContentText>
      </DialogContent>
      <DialogActions>
        <Button onClick={handleClose} color="primary" autoFocus>
          close
        </Button>
      </DialogActions>
    </Dialog>
 ) 

  return(
    <Fragment>
      {getMatchCard()}
      {getDialog()}
    </Fragment>
  )
};
export default MyCard;
