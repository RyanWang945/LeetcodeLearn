package 实验性测试;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/3/29 11:29
 */
public class UndergroundSystem {
    Map<Integer,Integer> persontime1;
    Map<Integer,Integer> persontime2;
    Map<Integer,String> start;
    Map<Integer,String> end;
    public UndergroundSystem() {
        persontime1=new HashMap<>();
        persontime2=new HashMap<>();
        start=new HashMap<>();
        end=new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        persontime1.put(id,t);
        start.put(id,stationName);
    }

    public void checkOut(int id, String stationName, int t) {
        persontime2.put(id,t);
        end.put(id,stationName);
    }

    public double getAverageTime(String startStation, String endStation) {
        int count=0;
        double counttime=0;
        for(Integer id:start.keySet()){
            if(start.get(id).equals(startStation)){
                if(end.containsKey(id)){
                    if(end.get(id).equals(endStation)){
                        if(persontime2.get(id)>persontime1.get(id)) {
                            count++;
                            counttime += persontime2.get(id) - persontime1.get(id);
                        }
                    }
                }

            }
        }
        return counttime/count;
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        undergroundSystem.getAverageTime("Paradise", "Cambridge");       // 返回 14.0。从 "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客于 time=10 出发于 time=20 到达。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");
    }
}
