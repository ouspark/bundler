'use strict';

var webpack = require('webpack');

module.exports = {
    plugins: [
        new webpack.NoEmitOnErrorsPlugin(),
    ],
    module: {
        rules: [
            {
                test: /\.css$/,
                use: 'style-loader'
            },
            {
                test: /\.css$/,
                use: 'css-loader'
            },
            {
                test: /\.(png|jpg|gif|svg|eot|ttf|woff|woff2)$/,
                use: 'url-loader'
            }
        ]
    }
};
