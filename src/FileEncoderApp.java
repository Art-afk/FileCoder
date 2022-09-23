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
 * <p>
 * C:\Users\Zar\IdeaProjects\FileEncoderApp\Tests\stdCoder.txt
 * C:\Users\Zar\IdeaProjects\FileEncoderApp\Tests\stdDeCoder.txt
 */

public class FileEncoderApp {
    public static void main(String[] args) throws Exception {
        ArgumentProcessing argsProcessing = new ArgumentProcessing();
        if (args.length != 0) argsProcessing.workingWithArguments(args);
        else System.out.println("need add Args to work");
    }//main
}//class
