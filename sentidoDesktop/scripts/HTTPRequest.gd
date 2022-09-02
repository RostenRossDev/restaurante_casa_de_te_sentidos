extends HTTPRequest


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
var url ="http://127.0.0.1:8080"
var path ="/oauth/token"
var loginUrl = url+path
onready var username ="RostenRoss" #$"../LineEdit"
onready var password ="12345" #$"../LineEdit2"

# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	var header: PoolStringArray=[]
	header.append('Content-Type: application/x-www-form-urlencoded')
	var userString ="username:"+username	
	var passString ="grant_type:"+"password"	
	var grant ="password:"+password
	var body = "{"+userString+","+passString+","+grant+"}"
	self.set_use_threads(true)
	self.connect("request_completed", self, "doSomething")
	self.request(loginUrl, header, true, HTTPClient.METHOD_POST, body)
	pass # Replace with function body.

func doSomething(result, response_code, headers, body: PoolByteArray):
	print(body)
	var data =body.get_string_from_utf8()
	print(data)
	pass

# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
