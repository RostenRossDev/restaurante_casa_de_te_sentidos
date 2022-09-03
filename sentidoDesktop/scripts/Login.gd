extends Control

onready var http = $Panel/HTTPRequest
# Declare member variables here. Examples:
# var a = 2
# var b = "text"

var baseUrl="http://127.0.0.1:8080"
var path="/oauth/token"
var loginUrl=baseUrl+path

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
	print("post http")
	print("username:"+username)
	print("password:"+password)	
	print("grant_type:"+grantType)
	#var query:=JSON.print({"grant_type":grantType, "username":username, "password":password})
	var data = "username="+username+"&password="+password+"&grant_type=password";
	var header =["Authorization:Basic cmVhY3RTZW50aWRvc0FwcDpzZW50aWRvczMzOTk=","Content-Type:application/x-www-form-urlencoded"]
	print("data :"+data)
	http.request(loginUrl, header, false, HTTPClient.METHOD_POST, data)
	pass # Replace with function body.


func _on_HTTPRequest_request_completed(result, response_code, headers, body):	
	print("body utf8: ")	
	#print(body.get_string_from_utf8())
	#print(body.get_string_from_utf8())
	var parseResult = JSON.parse(body.get_string_from_utf8())
	#print(parseResult.access_token)
	
	print(typeof(parseResult.result))
	print(parseResult.result.access_token)
	global.setToken(parseResult.result.access_token)
	if result ==HTTPRequest.RESULT_SUCCESS:
		if response_code ==200:
			#print(body.get_string_from_utf8())
			get_tree().change_scene("res://escenas/Main.tscn")
		else:
			print("http error")
