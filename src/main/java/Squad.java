import java.util.ArrayList;
import java.util.List;

public class Squad {
  private String mName;
  private int mId;
  private static List <Squad> instances = new ArrayList<Squad>();

  public Hero(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mHeroes = new ArrayList<Hero>();

  }

  public String getName() {
    return mName;
  }

  public int getAge() {
    return mAge;
  }

  public String getPower() {
    return mPower;
  }

  public String getWeakness() {
    return mWeakness;
  }

  public int getId() {
    return mId;
  }

  public static Hero find(int id) {
    return instances.get(id - 1);
  }

}
