extends Control

onready var http = $Panel/HTTPRequest
onready var httpGetData = $Panel/getUserData
# Declare member variables here. Examples:
# var a = 2
# var b = "text"

var baseUrl="http://127.0.0.1:8080"
var oauth="/oauth/token"
var userData="/api/v1/user/"
var loginUrl=baseUrl+oauth
var userDataUrl=baseUrl+userData

# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass


func _on_Button_pressed():
	var username ="RostenRoss" #$Panel/LineEdit.text
	var password ="12345" #$Panel/LineEdit2.text
	var grantType="password"	

	var data = "username="+username+"&password="+password+"&grant_type=password";
	var header =["Authorization:Basic cmVhY3RTZW50aWRvc0FwcDpzZW50aWRvczMzOTk=","Content-Type:application/x-www-form-urlencoded"]

	http.request(loginUrl, header, false, HTTPClient.METHOD_POST, data)


func _on_HTTPRequest_request_completed(result, response_code, headers, body):	
	
	#print(body.get_string_from_utf8())
	
	var parseResult = JSON.parse(body.get_string_from_utf8())
	#print(parseResult.result.access_token)
	var token =parseResult.result.access_token
	var username =parseResult.result.username
	if result ==HTTPRequest.RESULT_SUCCESS:
		if response_code ==200:
			#print(body.get_string_from_utf8())
			global.setToken(parseResult.result.access_token)
			var header =["Authorization:Bearer "+token,"Content-Type:application/json"]
			print(header[1])
			print(header[0])
			httpGetData.request((userDataUrl+"?username="+username), header, false)			
		else:
			print("http error")


func _on_getUserData_request_completed(result, response_code, headers, body):
	#print("body utf8: ")	
	#print("hola: "+body.get_string_from_utf8())
	print(body.get_string_from_utf8())
	var parseResult = JSON.parse(body.get_string_from_utf8())
	
	if result ==HTTPRequest.RESULT_SUCCESS:
		if response_code ==200:
			global.setUName(parseResult.result.name)
			global.setLastname(parseResult.result.lastname)
			global.setEmail(parseResult.result.email)
			get_tree().change_scene("res://escenas/Main.tscn")
		else:
			print("http error")
