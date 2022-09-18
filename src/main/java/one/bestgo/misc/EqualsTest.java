package one.bestgo.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualsTest {
  public static void main(String[] args) {
    /// Use case 1
    Alpha alpha1 = new Alpha("baechul");
    Alpha alpha2 = new Alpha("baechul");

    // The default impl. of Object#equals() returns true when both points to
    // the same memory address (same as ==)
    System.out.println(alpha1.equals(alpha2));  // false

    /// Use case 2
    String str1 = "haha";
    String str2 = "haha";
    // true because String override Object#equals() to compare the content
    System.out.println(str1.equals(str2));  // true
    System.out.println(((Object)str1).equals((Object)str2));  // true

    /// Use case 3
    Student st1 = new Student("SD1");
    Student st2 = new Student("SD1");

    Map<Student, Integer> scores = new HashMap<>();
    scores.put(st1, 70);
    scores.put(st2, 70);  // st1 and st2 are the same student hence should be treated as the same key.
    System.out.println("# of student: "+scores.size());

  }
}

class Student {
  private String id;
  public String getId() { return id; }

  public Student(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if(o != null && o instanceof Student) {
      String otherId = ((Student) o).getId();
      return otherId != null && otherId.equals(this.id);
    }
    return false;
  }


  @Override
  public int hashCode() {
    return this.id.hashCode();
  }

  // IDE generated equals/hashCode
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    Student student = (Student) o;
//    return Objects.equals(id, student.id);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(id);
//  }
}

class Alpha {
  private String value;

  public Alpha(String value) {
    this.value = value;
  }
}