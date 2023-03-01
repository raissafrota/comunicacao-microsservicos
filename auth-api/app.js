import express from "express";

const app = express();
const env = process.env;
const PORT = env.PORT || 8080;

app.listen(PORT, () => {
    console.info(`Server started successfully at port ${PORT}`);
});

app.get("/api/status", (req, res) => {
    return res.status(200).json(getOkResponse());
});
  
function getOkResponse() {
   return {
     service: "Auth-API",
     status: "up",
     httpStatus: 200,
   }
}