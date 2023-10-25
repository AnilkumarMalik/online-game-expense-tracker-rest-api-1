import React from "react";

 
import { AppBar, Button, IconButton, Toolbar, Typography} from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';
//import makeStyles from '@mui/styles';

//const useStyle = makeStyles((theme) => {
 // console.log("STYLE", theme);
//});

const Navbar = () => {
  //const classes = useStyle();

  return (
    <div>
      <AppBar  color="primary" sx={{bgcolor:'#141b2d' }} position="static" style={{ flexFlow: 1 }}>
        <Toolbar>
          <IconButton edge="start" color="inherit">
            <MenuIcon/>
          </IconButton>

          <Typography variant="h6">Live Score </Typography>

          <span style={{ flexGrow: 1 }}></span>

          <Button color="inherit">LogOut</Button>
        </Toolbar>
      </AppBar>
    </div>
  );
};

export default Navbar;