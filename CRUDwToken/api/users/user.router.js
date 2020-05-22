/* app.js will use the routers below to and functions associated with the route
to execute the functions.  The method or func are from "user.controller" */



const { createUser, getUserByUserId, getUsers, updateUsers, deleteUser, login } = require("./user.controller");

const router = require('express').Router();

const { checkToken } = require("../../auth/token_validation");

router.post("/", checkToken, createUser);    //when use localhost:3000/

router.get("/", checkToken, getUsers);

router.get("/:id", checkToken, getUserByUserId);

router.patch("/", checkToken, updateUsers);

router.delete("/", checkToken, deleteUser);

router.post("/login", login);

module.exports = router;