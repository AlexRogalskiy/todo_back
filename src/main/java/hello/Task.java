package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tasks")
public class Task {

  @Id
  @Column(name="id")
  private long id;

  @Column(name="name")
  private String name;

  @Column(name="date")
  private java.sql.Date date;

  @Column(name="is_urgent")
  private int isUrgent;


  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public java.sql.Date getDate() {
    return this.date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

  public long getIsUrgent() {
    return this.isUrgent;
  }

  public void setIsUrgent(int isUrgent) {
    this.isUrgent = isUrgent;
  }
}
