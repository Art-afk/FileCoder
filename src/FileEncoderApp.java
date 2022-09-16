
/**
 * Программа по кодированию/декодированию данных. На вход получает адрес файла. Файл для кодирования может
 * содержать последовательность символов a-z (нижний регистр). Файл для декодирования
 * может содержать последовательность символов a-z и цифры.
 * При режиме "Кодирование" программа "сокращает" данные последовательности,
 * удаляя все повторяющиеся подряд идущие символы, и заменяющая их числом, указывающим на количество повторений.
 * Входная последовательность:
 * aaassearsssrmm
 * Выходная последовательность:
 * a3s2ears3rm2
 * При режиме "декодирование" программа выполняет обратное действие.
 * Вся бизнес логика должна быть обложена тестами
 * Все необходимые параметры берём из args
 * На выходе должен быть готовый jar файл, который можно использовать из командной строки
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
