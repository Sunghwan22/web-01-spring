// find 기능은 지금은 필요없는 것 같고 "관리"만 해주면 될 것 같음
// param의 내용을 받아서 add를 해주는건 service의 역할인가?

package com.TodoList.repositories;

import com.TodoList.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
  private List<Task> tasks = new ArrayList<>();

  public List<Task> tasks() {
    return tasks;
  }

  public int tasksCount() {
    return tasks.size();
  }
}
