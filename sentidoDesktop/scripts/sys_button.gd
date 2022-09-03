extends ColorRect


enum TYPES {close, maximize, minimize}
export (TYPES) var types=TYPES.close
export (StreamTexture) var icon =preload("res://resource/icons/x.svg")
# Declare member variables here. Examples:
# var a = 2
# var b = "text"

onready var homeMax=$"../../../ScrollContainer/VBoxContainer/Pages/Home/max"
onready var homeMin=$"../../../ScrollContainer/VBoxContainer/Pages/Home/min"

onready var pedidosMax=$"../../../ScrollContainer/VBoxContainer/Pages/pedidos/max"
onready var pedidosMin=$"../../../ScrollContainer/VBoxContainer/Pages/pedidos/min"

# Called when the node enters the scene tree for the first time.
func _ready():
	$"icon".texture = icon


func _on_sys_button_gui_input(event):
	if event is InputEventMouseButton:
		if event.is_pressed() and event.get_button_index()==1:
			if types == TYPES.close:
				get_tree().quit()
			elif types == TYPES.minimize:
				OS.set_window_minimized(true)				
			else:
				var isMaxmimized =OS.is_window_maximized()
				OS.set_window_maximized(!isMaxmimized)
				if !isMaxmimized:
					homeMin.visible = false
					homeMax.visible = true
					pedidosMax.visible=true
					pedidosMin.visible=false
				else:
					homeMin.visible = true
					homeMax.visible = false
					pedidosMax.visible=false
					pedidosMin.visible=true
					
func _on_sys_button_mouse_entered():
	if types==TYPES.close:
		$".".color = "#e11f1f"
	else:
		$".".color = "#7735b9"


func _on_sys_button_mouse_exited():
	$".".color = "#5f1e47"
