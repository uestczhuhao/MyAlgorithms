package ZhuBaJie;

import java.util.*;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            Map<String,Integer> map = new HashMap<>();
            for (int i=0;i<n;i++){
                String str = sc.nextLine();
                if(map.get(str) != null){
                    map.put(str,map.get(str)+1);
                    System.out.println(str+map.get(str));
                } else {
                    map.put(str,0);
                    System.out.println("OK");
                }
//                char[] chs = str.toCharArray();
//                if (set.size() !=0 && set.contains(str)){
//                    if (chs[chs.length-1] >='0' && chs[chs.length-1] <='9'){
//                        char ch = chs[chs.length-1];
//                        ch++;
//                        chs[chs.length-1] = ch;
//                        str = String.valueOf(chs);
//                    } else {
//                        str += "1";
//                    }
//                    set.add(str);
//                } else {
//                    set.add(str);
//                    System.out.println("OK");
//                }
//                System.out.println(set);
            }
        }
    }
}



/*
#include<iostream>

#include<algorithm>
#include<string>
#include<vector>
using namespace std;

int main()
{
	int n;
	while (cin >> n)
	{
		string str;
		vector<string> res;
		for (int i = 0; i < n; i++)
		{
			cin >> str;

			if (!res.empty() && find(res.begin(), res.end(), str) != res.end())
			{
				str += to_string(1);
				cout << str << endl;
			}
			else
			{
				res.push_back(str);
				cout << "OK" << endl;
			}


		}

	}
	return 0;
}
 */