import { ADMINLOGIN } from "./ActionType"
const initialValue = {
    signin: null,
}

export const adminReducer = (store = initialValue, { type, payload }) => {
    if (type === ADMINLOGIN) {
        return { ...store, signin: payload }
    }
    return store;
}