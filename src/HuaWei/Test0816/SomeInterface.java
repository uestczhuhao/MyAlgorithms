package HuaWei.Test0816;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhuhao on 17-8-16.
 * 一个系统的若干模块间存在互相依赖的关系。 如果A模块调用了B模块的接口，那么成为A依赖B,记为A-->B
 如果A-->B，B-->A。那么称A和B模块都存在循环依赖。
 如果A-->B，B-->C，C-->D, D-->B。那么BCD存在循环依赖，A不存在循环依赖，依次类推。
 先输入若干模块之间的关系，判断某模块是否存在循环依赖。
 模块的 ID范围 0~0xffffffff
 调用者保证相同的关系不重复输入。
 实现接口
 //接口功能：添加依赖关系
 //说明：ModuleId 模块依赖 DependModuleId 调用者保证ModuleId不等于DependModuleId
 void AddDependency(unsigned int ModuleId, unsigned int DependModuleId);
 //接口功能：判断模块是否存在依赖关系
 //说明：如果模块不存在返回false
 bool MouldeIsCycularDependency(unsigned int ModuleId);
 //接口功能：清空模块数据
 void clear(void)；
 输入描述:
 模块间关系，注意最后一行没有','结尾
 输出描述:
 模块是否循环循环依赖，注意最后一行没有','结尾
 示例1
 输入

 {0x00, 0x01},
 {0x02, 0x03},
 {0x03, 0x04}
 输出

 {0x00, false},
 {0x01, false},
 {0x02, false},
 {0x03, false},
 {0x04, false}
 */
public class SomeInterface {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner ( System.in );
//        ArrayList<Integer> input = new ArrayList<> (  );
//        while (sc.hasNext ()){
//            String str = sc.nextLine ();
//
//        }
//    }

    //接口功能：添加依赖关系
    //说明：ModuleId 模块依赖 DependModuleId 调用者保证ModuleId不等于DependModuleId
//    void AddDependency(int ModuleId, int DependModuleId){
//
//    }
//
//    //接口功能：判断模块是否存在依赖关系
//    //说明：如果模块不存在返回false
//    boolean MouldeIsCycularDependency(int ModuleId){
//
//    }
//
//    //接口功能：清空模块数据
//    void clear(void){
//
//    }
}
