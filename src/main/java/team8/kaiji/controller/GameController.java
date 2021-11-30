package team8.kaiji.controller;

import java.util.ArrayList;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team8.kaiji.model.Room;
import team8.kaiji.model.User;
import team8.kaiji.model.UserMapper;

@Controller
@RequestMapping("/game")
public class GameController {

  @Autowired
  private Room room;

  @Autowired
  private UserMapper userMapper;

  @GetMapping("step1")
  public String step1(ModelMap model, Principal prin) {
    User userlist = new User();
    userlist.setName(prin.getName());
    userMapper.insertUser(userlist);
    ArrayList<User> user = userMapper.selectAllUser();
    model.addAttribute("user", user);
    return "main.html";
  }

  @GetMapping("step2")
  public String step2(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);

    return "main.html";
  }

  @GetMapping("match")
  public String battle(Principal prin, ModelMap model, @RequestParam Integer id) {
    String username = userMapper.selectNameById(id);
    model.addAttribute("enemyname", username);
    return "match.html";
  }

  /*
   * @GetMapping("janken/{hand}") public String janken(ModelMap
   * model, @PathVariable hand){
   *
   * }
   */
}
