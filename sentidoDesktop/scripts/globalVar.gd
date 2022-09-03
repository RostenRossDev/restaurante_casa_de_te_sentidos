extends Node


var token =""
var username=""
var reservas =[]

var selectedPage=""
# Declare member variables here. Examples:
# var a = 2
# var b = "text"


# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


func setToken(tokenStr):
	token=tokenStr

func getToken():
	return token
	
func setUsername(usernameStr):
	username=usernameStr

func getUsername():
	return username
# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass

func setSelectedPage(page):
	selectedPage	
	
func getSelectedPage():
	return selectedPage
