import { Grid, Typography } from "@mui/material";
import { useEffect, useState } from "react";
import Navbar from "./Navbar";
import MyCard from "./MyCard";
import { getMatches } from "../api/Api";
import "./User.css";

function Nav(){
    const [matches, setMatches] = useState([]);

  useEffect(() => {
    getMatches()
      .then((data) => {
        setMatches(data.matches)
        console.log(data.matches);
      })
      .catch();
  }, []);

  return (
    <div className="App">
      <Typography variant="h3" style={{ marginTop: 20 }}>
        Welcome
      </Typography>

      <Navbar />
      <Grid container>
        <Grid sm="3"></Grid>
        <Grid sm="6">
          {matches.map((match) => (
            <MyCard key={match.id} match={match} />
          ))}
        </Grid>
      </Grid>
    </div>
 );
}
export default Nav;