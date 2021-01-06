# Shopney Code Study
Template for Shopney Code Study assessment.

  - [Getting Started](https://github.com/mahirsayilir/shopney-code-study#getting-started)
  - [Operations](https://github.com/mahirsayilir/shopney-code-study#operations)
    - [Create a Shop API](https://github.com/mahirsayilir/shopney-code-study#create-a-shop-api)
    - [Login to system with the Shop API](https://github.com/mahirsayilir/shopney-code-study#login-to-system-with-the-shop-api)
    - [Disable the Shop API](https://github.com/mahirsayilir/shopney-code-study#disable-the-shop-api)
    - [List the Plugins API](https://github.com/mahirsayilir/shopney-code-study#list-the-plugins-api)
    - [Enable/Disable the Plugins API](https://github.com/mahirsayilir/shopney-code-study#enabledisable-the-plugins-api)

# Getting Started
This documentation is for understanding the API of the Shopney Code Study.What you will achieve is understand the all endpoints, request and responses.<br>
For live testing: [Heroku Swagger UI](https://obscure-dawn-09348.herokuapp.com/swagger-ui.html#/)

# Operations
There is 5 different operation on this project.There are basics of the systems Shop logic.If we will look closer to our operations;

  - Create a Shop
  - Login to system with the Shop
  - Disable the Shop
  - List the Plugins
  - Enable/Disable the Plugins

Now we can look deeper to our operations details that will be contains all API informations.

### Create a Shop API
<b>For:</b> This API is for creating a new shop. <br>
<b>Endpoint:</b> `http://localhost/register` <br>
<b>Method:</b> POST <br>
<b>Request Model:</b> <br>
`
{
  "shopName": string,
  "password": string
}
` <br>
<b>Response:</b> <br>
`
{
  "message": "success",
  "responseCode": 200
}
` <br>
<b>Notes:</b> The `shopName` field should be unique.

### Login to system with the Shop API
<b>For:</b> This API is for login to system with shop. <br>
<b>Endpoint:</b> `http://localhost/login` <br>
<b>Method:</b> POST <br>
<b>Request Model:</b> <br>
`
{
  "shopName": string,
  "password": string
}
` <br>
<b>Response:</b> <br>
`
{
  "message": "success",
  "responseCode": 200
}
` <br>

### Disable the Shop API
<b>For:</b> This API is for disable the shop from system <br>
<b>Endpoint:</b> `http://localhost/shops/` <br>
<b>Method:</b> DELETE <br>
<b>Request Model:</b> N/A<br>
<b>Response:</b> <br>
`
{
  "message": "success",
  "responseCode": 200
}
` <br>

### List the Plugins API
<b>For:</b> This API is for listing shop's available plugins. <br>
<b>Endpoint:</b> `http://localhost/shops/plugins` <br>
<b>Method:</b> GET <br>
<b>Request Model:</b> N/A<br>
<b>Response:</b> <br>
`
{
  "message": "success",
  "responseCode": 200,
  "response": Array
}
` <br>

### Enable/Disable the Plugins API
<b>For:</b> This API is for enable/disable shop's plugins. <br>
<b>Endpoint:</b> `http://localhost/shops/plugins/{pluginId}` <br>
<b>Method:</b> PUT <br>
<b>Request Model:</b> N/A <br>
<b>Response:</b> <br>
`
{
  "message": "success",
  "responseCode": 200
}
` <br>
<b>Path Variables:</b> `pluginId: String, This id should be a valid plugin id.`,
