package kirinman.miniproject_kiosk.controller;

import kirinman.miniproject_kiosk.dto.MenuRequestDto;
import kirinman.miniproject_kiosk.dto.OrderRequestMsgDto;
import kirinman.miniproject_kiosk.entity.Menu;
import kirinman.miniproject_kiosk.service.MenuService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/store/menus")
    public void menusList(@RequestBody MenuRequestDto requestDto) {
        menuService.postMenu(requestDto);
    }

    @GetMapping("/store/menus")
    public List<Menu> lookingMenus(){
        return menuService.showMenu();
    }

    @DeleteMapping("/store/menus/{id}")
    public OrderRequestMsgDto deleteMenus(@PathVariable Long id) {
        return menuService.deleteMenu(id);
    }


}
