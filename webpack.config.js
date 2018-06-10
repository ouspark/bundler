
var config = require('./scalajs.webpack.config');

var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = config;

module.exports.plugins = [
    new HtmlWebpackPlugin()
]