extends Control


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
onready var heading_date =$HBoxContainer/body/TopBar/Titlebar/date
const weekday ={1:"Lunes",2:"Martes",3:"Miercoles",4:"Jueves",5:"Viernes",6:"Sabado",7:"Domingo"}
const meses={1:"Enero",2:"Febrero",3:"Marzo",4:"Abri",5:"Mayo",6:"Junio",7:"Julio",8:"Agosto",9:"Septiembre",10:"Octubre",11:"Noviembre",12:"Diciembre",}
# Called when the node enters the scene tree for the first time.
func _ready():
	var dateStr= (Time.get_date_string_from_system (false ))
	heading_date.text= getCompleteDateString(dateStr)
	pass # Replace with function body.

func getCompleteDateString(dateStr):
	var date = Time.get_datetime_dict_from_datetime_string(dateStr,true)
	var retorno =str(weekday.get(date.weekday))+", "+str(date.day)+" de "+str(meses.get(date.month)+" del "+str(date.year))	
	return retorno
# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
