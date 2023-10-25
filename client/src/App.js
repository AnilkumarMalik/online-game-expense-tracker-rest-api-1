import { Route, Routes } from "react-router-dom";
import "./App.css";
import "./User.css";

import Login from "./Component/User/Login";
import Register from "./Component/User/Register";

import { Provider } from "react-redux";
import { store } from "./Component/Redux/store";
import Signin from "./Component/Admin/Signin";

function App() {
  return (
    <Provider store={store}>
      <div className="App">
        <Routes>
          <Route path="/" element={<Login />}></Route>
          <Route path="/admin" element={<Signin />}></Route>
          <Route path="/userSignin" element={<Login />}></Route>
          <Route path="/userSignup" element={<Register />}></Route>
        </Routes>
      </div>
    </Provider>
  );
}

export default App;
