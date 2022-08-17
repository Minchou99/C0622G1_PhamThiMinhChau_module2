package algorithm.weds;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        /*
        Chương trình sửa lại xâu kí tự:

Cho một xâu kí tự s gồm nhiều từ. Trong đó mỗi từ sẽ được bắt đầu bởi một kí tự in hoa.
Vì một lí do gì đó, người ta quên chèn các khoảng trắng giữa các từ.
Hãy viết chương trình sửa lại xâu kí tự đó theo yêu cầu sau:
Tách các từ, và thêm 1 kí tự cách (space) giữa 2 từ liên tiếp
Chuyển đổi các kí tự in hoa thành kí tự in thường
Ví dụ:
Với s = "CodegymDaNang", thì kết quả amendTheSentence(s) = "codegym da nang"
Với s = "Hello", thì kết quả amendTheSentence(s) = "hello"
         */

        String charStart = "CodegymDaNang";
        String[] strings = charStart.split("");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == strings[i].toUpperCase() && i != 0) {
                list.add(" ");
                list.add(strings[i]);
            } else {
                list.add(strings[i]);
            }
        }
        String str="";
        for (int i = 0; i <list.size() ; i++) {
            str+=list.get(i);
        }
        System.out.println(str);
    }
}
