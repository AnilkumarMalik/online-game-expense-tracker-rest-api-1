import { applyMiddleware, combineReducers, legacy_createStore } from "redux";
import thunk from "redux-thunk";
import { authReducer } from "./Auth/Reducer";
import { adminReducer } from "./Admin/Reducer";


const rootReducer=combineReducers({
    auth:authReducer,
    admin:adminReducer
})

export const store=legacy_createStore(rootReducer,applyMiddleware(thunk))