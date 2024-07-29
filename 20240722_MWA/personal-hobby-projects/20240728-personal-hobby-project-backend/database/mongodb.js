const mongoose = require("mongoose");
const callbackify = require("util").callbackify;

const mongoose_connection_close_WithCallback = callbackify(
  mongoose.connection.close
);

const mongoose_onConnectedEventCallback = function () {
  console.log("Connected to MongoDB");
};

const mongoose_onDisconnectedEventCallback = function () {
  console.log("Disconnected from MongoDB.");
};

const mongoose_onErrorEventCallback = function (error) {
  console.log("Error establishing connection to MongoDB.", error);
};

const mongoose_onConnectionCloseCallback = function (err) {
  console.log("Disconnected from MongoDB successfully.");
  process.exit(0);
};

const process_onInteruptSignalCallBack = function () {
  //   console.log("Interupt signal received");

  mongoose_connection_close_WithCallback(mongoose_onConnectionCloseCallback);
};
const process_onTerminateSignalCallBack = function () {
  //   console.log("Termination signal received");

  mongoose_connection_close_WithCallback(mongoose_onConnectionCloseCallback);
};
const process_onRestartSignalCallBack = function () {
  //   console.log("Restart signal");

  mongoose_connection_close_WithCallback(mongoose_onConnectionCloseCallback);
};

mongoose.connection.on("connected", mongoose_onConnectedEventCallback);
mongoose.connection.on("disconnected", mongoose_onDisconnectedEventCallback);
mongoose.connection.on("error", mongoose_onErrorEventCallback);

process.on("SIGINT", process_onInteruptSignalCallBack);
process.on("SIGTERM", process_onTerminateSignalCallBack);
process.on("SIGUSR2", process_onRestartSignalCallBack);

mongoose.connect(process.env.MONGODB_CONNECTION_URL);
