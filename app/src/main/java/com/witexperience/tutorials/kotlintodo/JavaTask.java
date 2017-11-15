package com.witexperience.tutorials.kotlintodo;

import java.io.Serializable;

public class JavaTask implements Serializable {

  String description;
  Boolean completed;

  public JavaTask(String description, Boolean completed) {
    this.description = description;
    this.completed = completed;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof JavaTask)) {
      return false;
    }

    JavaTask javaTask = (JavaTask) o;

    if (getDescription() != null ? !getDescription().equals(javaTask.getDescription())
        : javaTask.getDescription() != null) {
      return false;
    }
    return getCompleted() != null ? getCompleted().equals(javaTask.getCompleted())
        : javaTask.getCompleted() == null;
  }

  @Override
  public int hashCode() {
    int result = getDescription() != null ? getDescription().hashCode() : 0;
    result = 31 * result + (getCompleted() != null ? getCompleted().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "JavaTask{" +
        "description='" + description + '\'' +
        ", completed=" + completed +
        '}';
  }
}
