extends Control

onready var anim_player =$"../../../../../AnimationPlayer"


func _on_ToggleButton_gui_input(event):
	print("algo")
	if event is InputEventMouseButton:
		if event.get_button_index()==1 and event.is_pressed():
			if $"../../../".rect_min_size[0]==70:
				print("expandiendo")
				anim_player.play("side_animation")
			else:
				anim_player.play_backwards("side_animation")
				print("contrayendo")


func _on_ToggleButton_mouse_entered():
	print("algo")
