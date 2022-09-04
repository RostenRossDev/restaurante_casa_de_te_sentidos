extends Node


var token = ""
var username = ""
var uName = ""
var email = ""
var lastname = ""
var reservas =[]

var selectedPage=""
# Declare member variables here. Examples:
# var a = 2
# var b = "text"


# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


func getLastname():
	return lastname
		
func setLastname(lastname):
	lastname=lastname


func getEmail():
	return email
		
func setEmail(emai):
	email=emai

func getUName():
	return uName
		
func setUName(uname):
	uName=uname
	
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
