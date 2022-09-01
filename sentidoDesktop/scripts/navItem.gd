extends Control

export(StreamTexture) var icon
export var label ="Inicio"
export var active = false
export(NodePath) var page


func _ready():
	$ico.texture=icon
	$Label.text=label
	update_elements()

func set_active():
	active=true
	update_elements()
	
func deactive():
	active=false
	update_elements()
	
func update_elements():	
	$active.visible=active	
	get_node(page).visible=active
	
func _on_navItem_mouse_entered():
	$bg.color="#7735b9"



func _on_navItem_mouse_exited():
	$bg.color="#511379"


func _on_navItem_gui_input(event):
	if event is InputEventMouseButton:
		if event.is_pressed() and event.get_button_index() == 1:
			var navitems = get_tree().get_nodes_in_group("navItem")
			for item in navitems:
				item.deactive()
			set_active()
