package study;

/**
 *  @Author: liuqi
 *   @Description:
 *   @Date: Create in  2019/12/18
 *   1、Maven项目结构
 *   ProjectName
 *   |-src
 *   |   |-main         —— 主目录
 *   |   |  |-java        —— 存放项目的.java文件
 *   |   |  |-resources   —— 存放项目资源文件，如spring, hibernate配置文件
 *   |   |-test           ——测试目录
 *   |      |-java        ——存放所有测试.java文件，如JUnit测试类
 *   |      |-resources   —— 测试资源文件，如果这里没有配置文件则默认从main里找
 *   |-target             —— 目标文件输出位置例如.class、.jar、.war文件
 *   |-pom.xml           ——maven项目核心配置文件
 *
 *   2、Maven能干的事：编译  测试(junit)  运行  打包  部署
 *   3、mvn clean   清理编译的文件，删除target目录；
 *   4、mvn compile 编译了主目录的文件，把src/main下的代码进行编译，把编译后的.class文件放在生成的target目录下，该目录中存放了编译后的字节码文件
 *   5、mvn test  编译并运行了test目录的代码，编译了正式代码和测试代码。会在target目录中生成三个文件夹：surefire、surefire-reports（测试报告）、test-classes（测试的字节码文件）
 *   6、mvn package 打包(不包含test目录)，会在target目录中生成一个文件，该文件可能是jar、war
 *   7、mvn install 就是把项目发布到本地仓库，将打好的jar包安装到本地仓库的操作，会在本地仓库中出现安装后的jar包，方便其他工程引用
 *  8. mvn tomcat:run  一键启动
 *  9. mvn 组合命令
 *     mvn clean compile
 *     mvn clean test
 *     mvn clean package
 *     mvn clean install
 *  10、mvn clean install -Dmaven.test.skip=true
 *
 */

public class Maven命令学习 {
    public static void main(String[] args){


    }

}
