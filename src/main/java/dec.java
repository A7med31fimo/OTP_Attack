import jakarta.xml.bind.DatatypeConverter;

import javax.xml.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class dec {
    public static String stringTohexa(String s) {
        byte[] byteArray = s.getBytes();
        String hexString = DatatypeConverter.printHexBinary(byteArray);
        return hexString;
    }

    static byte[] strxor(byte[] a, byte[] b) {
        int length = Math.min(a.length, b.length);
        byte[] c = new byte[length];
        for (int i = 0; i < length; i++) {
            c[i] = (byte) (a[i] ^ b[i]);
        }
        return c;
    }

    public static String toHexa(byte[] bytes) {
        return DatatypeConverter.printHexBinary(bytes);
    }

    public static String hexToString(String hex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            char ch = (char) Integer.parseInt(str, 16);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String s[] = {
                "11192B6DBDAADC8A11F66CE549B56548875900B14D2F405D3E5F95A6F9F2DACB2FDFFC69ADCFC89D87127A5E2614D07C8715F1F8D5456BDDB2CB5549C6A6D52F4D0A877A7D033FE0E8B79C1274938F97FF1B9EF62340D24CF28CFD4B5447728D3C96122A31EE500FBF90A53A16311B4800375048FD728261E5BE5A00FBE29D3B347863A46E93F0B092F1CD8E5961D961CE5492F385D7FF9746FE5A82830DFD48F2EF85E8EC1E79747B151379751E080ABAFF03B90B86E83D7A84D39F3715E5515BDD8B56D4F56503728B628FF8FE74ED0271F15BD012CF6511479DFDE371CDBA8A0E4F03DB8693987F7566BE7DF96B51B4B7FF0985733B",
                "3C057971BFFF959903ED21A041B52C4D905902BF4D2F4D187F4599E3B0F59FC521C8B827A0D7879F804574417540D761D341F5F29A4C7D8EAB84444489BDD32B0F43A36B34146DDDE5BACF466CD29ED6FE16DBEC6641C919B59AFB41510667C83CD3082D76F31F16B590AB7C55291A484E2E1F42E627D56BE0B51611BAE18B7E31787DA07381E9A5D5E0D6CF4F34DF24D457DFE886C7ACD640F31FCB8B44F74CEDBF90E8E20E693761",
                "291E307BF0FEDA950EA376A453E626538C1818B55D664C183C5084F5F5A68DC36ED1BD69B6DE8CDC990475433A59926DC219EDBD93487C8EA99E4401DEAAD46A074FA3763A193EA7AD84D40375939093A90DD6ED3118C74CF18CE0474148269C37961A6472F15607B4C4",
                "5D253628A7E2CCDA11EB6EB04CA22B069D591BB5192C5B0E2B1192E9E0FFD7D62FD5A862E2DAC88F820B7C4B3014C17CC915FCF396422ECFA88F1646CCBB962B4348BC703E1C6DE6EBF3C80363C7C7C9A936DFF42318C74CF986FC45064772C82CDE1E6477F2530EB5C7A33251",
                "3C052A7DBDEF958E0AE275E549E62D409F1C4CB45C2047133A55D1E8F5F1DAF42FC8B868AF93DCCEC24572497557DE78D412B9FC9B432EC7A8CB574FC6BBDE2F110AB3733C043EA9E4F3DD017ADA89D6ED119EEC234F863EF487F7414B0E2FC837D8173D31FC5106FAD9EA3B59315349493C595EFB379B7CA1A9530AAEFB9A707E7666B62080EDB487F19ECF556D8D35C251DAE483D3AA9314EF128A990DF00DE2FE8EBAFE0F6874671118793A1C4E59ADFB09FD0387A72B7E90CBC67E1AAB4C14CE96049BE77D466C932C8BE1FE60FB026BB452D1469A65504B96FDF07DC0A6830E4802CD86818B3D6B73BE7FF16E02AEE3BA17856F7EB2AD241C291432192812E0423F2D7F84CBF1F1DC4473206FB2183B891E9A54FE0B655898C29CAB7D5C09CBDC74E590FF8F6AECA97CF922E08453ADF692F5B688DA03DDED070EFB63065472",
                "34027965B9EDDD8E42F064A04DE6304F9B1C00B14D234A5D2C589FE5F5A693D26ECBB975A7D791DC98007E4A2614C6768703FCBD94077CCBA08A5555C6BD9628165EF076295724FAADB7D90072DD8E82EC12C7A2345DCA0DE18CF700066956C82FD7086463F8120BB4C3BE3D58311A4C5433515CA9269D6DA1895717BFF8837E373D61A07295F1BE87B4DBD85E66D461D35BDFEFCAD6B79314F61F9F8542FD0DF6FE93BAEE0B70387014",
                "5D053628BEEFCD8E26EC74A74CA36556860C00B41927420A3E4882A6E2E38ED33CC8FC73AADEC89A821768537550DD6CC50DFCBD9C492EDAAE8E1653C8A1D2250E0AA37A2C0228E7EEB6",
                "291E387CF7F9958E0AE621B552AF2B42800900B51929485D3E11A1F5F5F39EC963F49240EC9BBC948E4575523856D76BD441F8EF900760C1B2CB4444C8A3DA334358B171391820",
                "2D04366ABCEFD8DA0BF021B148A73101901619F04A234B197F4599E3B0F49BC82AC9B127A5DE869999046F482714D37EC608F7B3D56278CBB4921655C0A2D36A1A45A53F2E1228EDADBAC8466FDB82D6E010D7F62F59CA",
                "0E02387CB5AADA9C42F769A000B4244F8D1601F05733431F3A43D1E1F5E89FD42FD2B375E2DC8D88984569422651C639C60FFDBD814F6B8EA0824452DDEFC42B0D4EBF727D1938E4EFB6CE4662DC92D6EE1BD0E73459D209B59EFA424A06648D78C2132131FB5610A9C4EA2E572B17424D7A514EE430907AA1BA500DBEE5CE2A383D2FAC6E9DF1B894F89EDD4F75D924",
                "291E3C28A3EFD68807F721A845B536408E1C4CB94A7C0E2A37549FA6E5F593C82986BD27B1CF9A998A083B443C44DA7CD541F7F883427C8EB3985301DDA7D36A084FA93F30183FECADA7D40775938898EA1B9EAA7701945BA7DEA007"
        };
        byte[] tmp = DatatypeConverter.parseHexBinary(s[10]);
        char[] predication = new char[s[10].length() / 2];
        for (int i = 0; i < 10; i++) {
            byte[] c2 = DatatypeConverter.parseHexBinary(s[i]);
            String t = hexToString(toHexa(strxor(tmp, c2)));
            int x = 0;
            for (int j = 0; j < t.length(); j++, x += 2) {
                if (Character.isAlphabetic(t.charAt(j))) {
//                    System.out.println(s[i].charAt(x)+""+s[i].charAt(x+1)+"^"+s[10].charAt(x)+""+s[10].charAt(x+1)+" = "+t.charAt(j));
                    predication[j] = Character.isUpperCase(t.charAt(j)) ? Character.toLowerCase(t.charAt(j)) : Character.toUpperCase(t.charAt(j));
                }
            }
//            if (i == 9) System.out.println(Arrays.toString(predication));
        }

        //we should make a guess
        /*
        oPut=[T,  , e, t, t, e, c, r, e, t, h, m, e, s, s, a,  , e, m, i, s, o, m, W, h, e, n, g, u, s, i,  , j, t, a, r,
        s, t, r, e, h, m, r,  , i, p, h, e, r, n, n, e, v, e, r, e,
        , s, e, s, t, h, e, a, k, e, y, m, m, o, r, e, b, t, h, a,  , o, o, n, c,  , n, m, c, x, f, r, f, r, z, e]




         *   suggestion=T, h , e, , s, e, c, r, e, t, , m, e, s, s, a, g , e, , i, s, , , W, h, e, n, , u, s, i, n , g, , a, , s, t, r, e, a, m, , s , i, p, h, e, r, , n, e, v, e, r, ,
         *   u, s, e, , t, h, e, , k, e, y, , m, o, r, e, , t, h, a,n , , o, n, c, e , n, m, c, x, f, r, f, r, z, e
        1E
        02
        04
        1E
        05
        02
        05
        25
        1E
        05
        19
         * */
        Scanner in = new Scanner(System.in);
        WordPredictor predictor = new WordPredictor("C:\\Users\\Fimo\\OTP_Attack\\src\\main\\java\\mydictionary.txt");
        int xx=0;
        while (true) {
            for (int i = 0; i < predication.length; i++) {
                System.out.print(predication[i] + "");
            }
            System.out.println();
            for (int i = xx; i < predication.length; i++) {
                System.out.print(predication[i] +"("+ (i+1)+") ");
            }
            System.out.println();
            System.out.println("Choose the index of the predication word  ");
            int l, r;
            l = in.nextInt();
            r = in.nextInt();
            xx=r;
            String w = "";
            for (int i = l-1; i < r; i++){
                w+=predication[i];
            }
            System.out.println("You Choose "+ w);
            List<String> suggestions = predictor.predictWords(w);
            if(suggestions.size()==0){
                System.out.println("no suggestions Words the word already correct");
            }
            System.out.println("suggestions Words Can Help You");
            System.out.println(suggestions);
            System.out.println();
            System.out.println("Choose Your Suggestion Word ");
            String word = in.next();
            boolean flg = true;
            for (int i = l - 1,b=0; i < r; i++,b++) {
                if (i == r - 1) {
                    predication[i + 1] = ' ';
                }
                if(i==0){
                    flg=false;
                }
                if (i > 0 && flg) {
                    predication[i - 1] = ' ';
                    predication[i] = word.charAt(b);
                    flg = false;
                } else {
                    predication[i] = word.charAt(b);
                }
            }
            for (int i = 0; i < predication.length; i++) {
                System.out.print(predication[i] + "");
            }
            System.out.println();
            System.out.println("Do You Want To Continue ? 1/0");
            int c = in.nextInt();
            if(c==0)
                break;
        }
        System.out.println(Arrays.toString(predication));
    }
    //1 3
    //5 10
    //12 18
    //20 21
    //24 27
    //29 33
    //35 35
    //37 42


}