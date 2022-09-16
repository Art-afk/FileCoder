
/**
 * ��������� �� �����������/������������� ������. �� ���� �������� ����� �����. ���� ��� ����������� �����
 * ��������� ������������������ �������� a-z (������ �������). ���� ��� �������������
 * ����� ��������� ������������������ �������� a-z � �����.
 * ��� ������ "�����������" ��������� "���������" ������ ������������������,
 * ������ ��� ������������� ������ ������ �������, � ���������� �� ������, ����������� �� ���������� ����������.
 * ������� ������������������:
 * aaassearsssrmm
 * �������� ������������������:
 * a3s2ears3rm2
 * ��� ������ "�������������" ��������� ��������� �������� ��������.
 * ��� ������ ������ ������ ���� �������� �������
 * ��� ����������� ��������� ���� �� args
 * �� ������ ������ ���� ������� jar ����, ������� ����� ������������ �� ��������� ������
 *
 * C:\Users\Zar\IdeaProjects\FileEncoderApp\Tests\stdCoder.txt
 * C:\Users\Zar\IdeaProjects\FileEncoderApp\Tests\stdDeCoder.txt
 */


public class FileEncoderApp {

    public static void main(String[] args) throws Exception {
        Coder coder = new Coder();
        Decoder decoder= new Decoder();
        FileWork fileWork = new FileWork();
        ArgsWorking argsWork = new ArgsWorking();
        Debug debug = new Debug();

        if (args.length == 0)
            System.out.println("need add Args to work");
        else
         argsWork.workingWithArguments(args);





    }//main

}//class
