package Meituan.Test0914;

import java.util.Scanner;

/*
int main(){
	int n;
	int a[10000];
	int num;
	cin >> n;
	for (int i = 0; i<n; i++){
		cin >> a[i];
	}
	int flag = false;
	int count_0 = 0;
	int count_1 = 0;
	for (int i = 1; i<n; i++){
		if (a[i] == a[i - 1] && a[i] == 1){
			flag = true;
			i++;
		}
		if (flag){
			count_0++;
		}
		else{
			count_1++;
		}
		flag = false;
	}
	if ((count_0 - count_1) % 2 == 0){
		cout << "Alice" << endl;
	}
	else{
		cout << "Bob" << endl;
	}
	return 0;
}
 */
public class CloseBuddle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i=0;i<n;i++)
                arr[i] = sc.nextInt();

//            if (n==1 && arr[0] == 0){
//                System.out.println("Bob");
//                return;
//            }
//            boolean flag = false;
//            int count0 = 0;
//            int count1 = 0;
//            for (int i = 1; i<n; i++){
//                if (arr[i] == arr[i - 1] && arr[i] == 1){
//                    flag = true;
//                    i++;
//                }
//                if (flag){
//                    count0++;
//                }
//                else{
//                    count1++;
//                }
//                flag = false;
//            }
//            if (Math.abs(count0 - count1) % 2 == 0){
//                System.out.println("Alice");
//            }
//            else{
//                System.out.println("Bob");
//            }
            if (arr[n-1] == 1)
                System.out.println("Alice");
            else
                System.out.println("Bob");
        }
    }
}
