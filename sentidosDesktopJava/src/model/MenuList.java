package model;

import java.util.List;

public class MenuList {
	private List<Menu> menues;

	
	public MenuList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuList(List<Menu> menuList) {
		super();
		this.menues = menuList;
	}

	public List<Menu> getMenuList() {
		return menues;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menues = menuList;
	}

	@Override
	public String toString() {
		return "MenuList [menuList=" + menues + "]";
	}
	
}
