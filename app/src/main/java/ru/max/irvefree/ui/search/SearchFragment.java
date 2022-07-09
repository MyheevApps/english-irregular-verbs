package ru.max.irvefree.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

import java.util.ArrayList;
import java.util.List;

import ru.max.irvefree.R;

public class SearchFragment extends Fragment {

    private SearchView searchViewSearch;
    private ListView listViewSearch;
    /**/
    private VerbsListAdapter adapter;
    private List<Verbs> mVerbsList;
    //working with ads
    private AdView mAdView;
    /**/
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        //working with ads
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        AdView adView = new AdView(getContext());
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        searchViewSearch = (SearchView) view.findViewById(R.id.searchViewSearch);
        listViewSearch = (ListView) view.findViewById(R.id.listViewSearch);

        mVerbsList = new ArrayList<>();

        mVerbsList.add(new Verbs(1, "придерживаться" , "abide [əˈbaɪd]" , "abode [əˈbəʊd]", "abode [əˈbəʊd]"));
        mVerbsList.add(new Verbs(2, "возникнуть", "arise [əˈraɪz]", "arose [əˈrəʊz]", "arisen [əˈrɪzən]" ));
        mVerbsList.add(new Verbs(3, "просыпаться", "awake [əˈweɪk]", "awoke [əˈwəʊk]", "awoken [əˈwəʊkən]"));
        mVerbsList.add(new Verbs(4, "клеветать", "backbite [ˈbækbaɪt]", "backbitten [ˈbækbɪtən]", "backbitten [ˈbækbɪtən]"));
        mVerbsList.add(new Verbs(5, "отпадать", "backslide [ˈbækslaɪd]", "backslid [bækˈslɪd]", "backslid [bækˈslɪd]"));
        mVerbsList.add(new Verbs(6,"быть", "be [bi]", "was [wɒz]", "been [biːn]"));
        mVerbsList.add(new Verbs(7, "нести, родить" , "bear [be]", "bore  [bɔː]", "born [bɔːn]"));
        mVerbsList.add(new Verbs(8, "бить" , "beat [biːt]", "beat [biːt]", "beaten [ˈbiːtən]"));
        mVerbsList.add(new Verbs(9, "становиться" , "become [bɪˈkʌm]","became [bɪˈkeɪm]", "become [bɪˈkʌm]"));
        mVerbsList.add(new Verbs(10, "случиться ", "befall [bɪˈfɔːl]", "befell [bɪˈfel]", "befallen [bɪˈfɔːlən]"));
        mVerbsList.add(new Verbs(11, "порождать" , "beget [bɪˈɡet]", "begot [bɪˈɡɒt]", "begotten [bɪˈɡɒtən]"));
        mVerbsList.add(new Verbs(12, "начать" , "begin [bɪˈɡɪn]", "began [bɪˈɡæn]", "begun [bɪˈɡʌn]"));
        mVerbsList.add(new Verbs(13, "опоясывать", "begird [bɪˈɡɜːd]", "begirt [bɪˈɡɜːt]", "begirt [bɪˈɡɜːt]"));
        mVerbsList.add(new Verbs(14, "зреть", "behold [bɪˈhəʊld]", "beheld [bɪˈheld]",  "beheld [bɪˈheld]"));
        mVerbsList.add(new Verbs(15, "гнуть", "bend [bend]", "bent [bent]", "bent [bent]"));
        mVerbsList.add(new Verbs(16, "лишать","bereave [bɪˈriːv]", "bereft [bɪˈreft]", "bereft [bɪˈreft]"));
        mVerbsList.add(new Verbs(17, "умолять, упрашивать" , "beseech [bɪˈsiːtʃ]", "besought [bɪˈsɔːt]", "besought [bɪˈsɔːt] "));
        mVerbsList.add(new Verbs(18, "осаждать", "beset [bɪˈset]", "beset [bɪˈset]", "beset [bɪˈset]"));
        mVerbsList.add(new Verbs(19, "свидетельствовать", "bespeak [bɪˈspiːk]", "bespoke [bɪˈspəʊk]", "bespoke [bɪˈspəʊk]"));
        mVerbsList.add(new Verbs(20, "заплевывать", "bespit [bɪˈspɪt]", "bespat [bɪˈspæt]", "bespat [bɪˈspæt]"));
        mVerbsList.add(new Verbs(21, "сидеть верхом", "bestride [bɪˈstraɪd]", "bestrode [bɪˈstrəʊd]", "bestridden [bɪˈstrɪdən]"));
        mVerbsList.add(new Verbs(22, "держать пари", "bet [ˈbet]","bet [ˈbet]", "bet [ˈbet]"));
        mVerbsList.add(new Verbs(24, "просить" ,"bid [bɪd]",  "bad [bæd]",  "bid [bɪd]"));
        mVerbsList.add(new Verbs(25, "связать", "bind [baɪnd]",  "bound [baʊnd]", "bound [baʊnd]"));
        mVerbsList.add(new Verbs(26, "кусать" , "bite [baɪt]", "bit [bɪt]", "bit [bɪt]"));
        mVerbsList.add(new Verbs(27, "кровоточить", "bleed [bliːd]", "bled [bled]", "bled [bled]"));
        mVerbsList.add(new Verbs(28, "благословлять", "bless [bles]", "blessed [blest]", "blessed [blest]"));
        mVerbsList.add(new Verbs(29, "дуть", "blow [bləʊ]", "blew [bluː]",  "blown [bləʊn]"));
        mVerbsList.add(new Verbs(30, "ломать", "break [breɪk]",  "broke [brəʊk]",  "broken [ˈbrəʊkən]"));
        mVerbsList.add(new Verbs(32, "выращивать, разводить", "breed [briːd]",  "bred [bred]",  "bred [bred]"));
        mVerbsList.add(new Verbs(33,"принести", "bring [brɪŋ]", "brought [ˈbrɔːt]", "brought [ˈbrɔːt]"));
        mVerbsList.add(new Verbs(34,"вещать", "broadcast [ˈbrɔːdkɑːst]", "broadcast [ˈbrɔːdkɑːst]", "broadcast [ˈbrɔːdkɑːst]"));
        mVerbsList.add(new Verbs(35,"запугивать", "browbeat [ˈbraʊbiːt]", "browbeat [ˈbraʊbiːt]", "browbeaten [ˈbraʊbiːtən]"));
        mVerbsList.add(new Verbs(36,"строить", "build [bɪld]",  "built [bɪlt]",  "built [bɪlt]"));
        mVerbsList.add(new Verbs(37,"гореть", "burn [bɜːn]", "burnt [bɜːnt]", "burnt [bɜːnt]"));
        mVerbsList.add(new Verbs(38,"взорваться", "burst [bɜːst]", "burst [bɜːst]", "burst [bɜːst]"));
        mVerbsList.add(new Verbs(39,"разжаловать", "bust [bʌst]", "bust [bʌst]", "bust [bʌst]"));
        mVerbsList.add(new Verbs(40,"купить", "buy [baɪ]",  "bought [ˈbɔːt ]",  "bought [ˈbɔːt]"));
        mVerbsList.add(new Verbs(41,"мочь", "can [kæn]", "could [kʊd]", "been able [biːn ˈeɪbl]"));
        mVerbsList.add(new Verbs(42,"отбрасывать", "cast [kɑːst]",  "cast [kɑːst]",  "cast [kɑːst]"));
        mVerbsList.add(new Verbs(43,"ловить", "catch [kætʃ]", "caught [ˈkɔːt]", "caught [ˈkɔːt]"));
        mVerbsList.add(new Verbs(44,"бранить", "chide [tʃaɪd]", "chid [tʃɪd]", "chid [tʃɪd]"));
        mVerbsList.add(new Verbs(45,"выбрать", "choose [tʃuːz]", "chose [tʃəʊz]", "chosen [ˈtʃəʊzən]"));
        mVerbsList.add(new Verbs(46,"рассечь"," cleave [kliːv]", "clove [kləʊv]", "cloven [ˈkləʊvən]"));
        mVerbsList.add(new Verbs(47,"цепляться", "cling [kəlɪŋ]", "clung [klʌŋ]", "clung [klʌŋ]"));
        mVerbsList.add(new Verbs(48,"прийти", "come [kʌm]", "came [keɪm]", "come [kʌm]"));
        mVerbsList.add(new Verbs(49,"стоить", "cost [kɒst]", "cost [kɒst]",  "cost [kɒst]"));
        mVerbsList.add(new Verbs(50,"зенковать", "countersink [ˈkaʊntəsɪŋk]", "countersank [ˈkaʊntəsæŋk]", "countersunk [ˈkaʊntəsʌŋk]"));
        mVerbsList.add(new Verbs(51,"ползти", "creep [kriːp]", "crept [krept]", "crept [krept]"));
        mVerbsList.add(new Verbs(52,"кукарекать", "crow [krəʊ]", "crowed [krəʊd]", "crowed [krəʊd]"));
        mVerbsList.add(new Verbs(53,"резать", "cut [kʌt]", "cut [kʌt]", "cut [kʌt]"));
        mVerbsList.add(new Verbs(54,"сметь", "dare [deə]", "durst [dɜːst]", "dared [deəd]"));
        mVerbsList.add(new Verbs(55,"иметь дело", "deal [diːl]", "dealt [delt]", "dealt [delt]"));
        mVerbsList.add(new Verbs(56,"копать", "dig [dɪɡ]", "dug [dʌɡ]", "dug [dʌɡ]"));
        mVerbsList.add(new Verbs(57,"нырять", "dive [daɪv]", "dived [daɪvd]", "dived [daɪvd]"));
        mVerbsList.add(new Verbs(58,"делать", "do [duː]", "did [dɪd]", "done [dʌn]"));
        mVerbsList.add(new Verbs(59,"рисовать", "draw [drɔː]", "drew [druː]", "drawn [drɔːn]"));
        mVerbsList.add(new Verbs(60,"мечтать", "dream [driːm]", "dreamt [dremt]", "dreamt [dremt]"));
        mVerbsList.add(new Verbs(61,"пить", "drink [drɪŋk]", "drank [dræŋk]", "drunk [drʌŋk]"));
        mVerbsList.add(new Verbs(62,"водить", "drive [draɪv]", "drove [drəʊv]", "driven [ˈdrɪvən]"));
        mVerbsList.add(new Verbs(63,"обитать", "dwell [dwel]", "dwelt [dwelt]", "dwelt [dwelt]"));
        mVerbsList.add(new Verbs(64,"кушать", "eat [iːt]", "ate [et]", "eaten [ˈiːtən]"));
        mVerbsList.add(new Verbs(65,"падать", "fall [fɔːl]", "fell [fel]", "fallen [ˈfɔːlən]"));
        mVerbsList.add(new Verbs(66,"кормить", "feed [fiːd]", "fed [fed]", "fed [fed]"));
        mVerbsList.add(new Verbs(67,"чувствовать", "feel [fiːl]", "felt [felt]", "felt [felt]"));
        mVerbsList.add(new Verbs(68,"сражаться", "fight [faɪt]", "fought [ˈfɔːt]", "fought [ˈfɔːt]"));
        mVerbsList.add(new Verbs(69,"находить", "find [faɪnd]", "found [faʊnd]", "found [faʊnd]"));
        mVerbsList.add(new Verbs(70,"бежать", "flee  [fliː]", "fled [fled]", "fled [fled]"));
        mVerbsList.add(new Verbs(71,"бросить", "fling [flɪŋ]", "flung [flʌŋ]", "flung [flʌŋ]"));
        mVerbsList.add(new Verbs(72,"освещать прожектором", "floodlight [ˈflʌdlaɪt]", "floodlighted [ˈflʌdlaɪtɪd]","floodlighted [ˈflʌdlaɪtɪd]"));
        mVerbsList.add(new Verbs(73,"летать", "fly [flaɪ]", "flew [fluː]", "flown [fləʊn]"));
        mVerbsList.add(new Verbs(74,"воздерживаться", "forbear [fɔːˈbeə]", "forbore [fɔːˈbɔː]", "forborne [fɔːˈbɔːn]"));
        mVerbsList.add(new Verbs(75,"запретить", "forbid [fəˈbɪd]", "forbad  [fəˈbæd]", "forbidden [fəˈbɪdən]"));
        mVerbsList.add(new Verbs(76,"предсказывать", "forecast [ˈfɔːkɑːst]", "forecast [ˈfɔːkɑːst]", "forecast [ˈfɔːkɑːst]"));
        mVerbsList.add(new Verbs(77,"предвидеть", "foresee [fɔːˈsiː]", "foresaw [fɔːˈsɔː]","foreseen [fɔːˈsiːn]"));
        mVerbsList.add(new Verbs(78,"предсказывать","foretell [fɔːˈtel]", "foretold [fɔːˈtəʊld]", "foretold [fɔːˈtəʊld]"));
        mVerbsList.add(new Verbs(79,"забыть", "forget [fəˈɡet]", "forgot [fəˈɡɒt ]", "forgotten [fəˈɡɒtən]"));
        mVerbsList.add(new Verbs(80,"простить", "forgive [fəˈɡɪv]", "forgave [fəˈɡeɪv]", "forgiven [fəˈɡɪvən]"));
        mVerbsList.add(new Verbs(81,"покидать", "forsake [fəˈseɪk]", "forsook [fəˈsʊk]", "forsaken [fəˈseɪkən]"));
        mVerbsList.add(new Verbs(82,"отрекаться", "forswear [fɔːˈsweə]", "forswore [fɔːˈswɔː]", "forsworn [fɔːˈswɔːn]"));
        mVerbsList.add(new Verbs(83,"замерзать", "freeze [friːz]", "froze [frəʊz]", "frozen [ˈfrəʊzən]"));
        mVerbsList.add(new Verbs(84,"отрицать", "gainsay [ˌɡeɪnˈseɪ]"," gainsaid [ˌɡeɪnˈsed]", "gainsaid [ˌɡeɪnˈsed]"));
        mVerbsList.add(new Verbs(85,"получить", "get [ˈɡet]", "got [ˈɡɒt]", "got [ˈɡɒt]"));
        mVerbsList.add(new Verbs(86,"позолотить", "gild [ɡɪld]", "gilt [ɡɪlt]", "gilt [ɡɪlt]"));
        mVerbsList.add(new Verbs(87,"подпоясывать", "gird [ɡɜːd]", "girded [ˈɡɜːdɪd]", "girded [ˈɡɜːdɪd]"));
        mVerbsList.add(new Verbs(88,"дать", "give [ɡɪv]", "gave [ɡeɪv]", "given [ɡɪvən]"));
        mVerbsList.add(new Verbs(89,"идти", "go [ɡəʊ]", "went [ˈwent]", "gone [ɡɒn]"));
        mVerbsList.add(new Verbs(90,"гравировать", "grave [ɡreɪv]", "graved [ɡreɪvd]", "graved [ɡreɪvd]"));
        mVerbsList.add(new Verbs(91,"молоть",  "grind [ɡraɪnd]", "ground [ɡraʊnd]", "ground [ɡraʊnd]"));
        mVerbsList.add(new Verbs(92,"расти", "grow [ɡrəʊ]", "grew [ɡruː]",  "grown [ɡrəʊn]"));
        mVerbsList.add(new Verbs(93,"подрезать поджилки", "hamstring [ˈhæmstrɪŋ]", "hamstringed [ˈhæmstrɪŋd]", "hamstringed [hæmstrɪŋd]"));
        mVerbsList.add(new Verbs(94,"висеть","hang [hæŋ]", "hung [hʌŋ]", "hung [hʌŋ]"));
        mVerbsList.add(new Verbs(95,"иметь", "have [hæv]",  "had [hæd]", "had [hæd]"));
        mVerbsList.add(new Verbs(96,"слушать", "hear [hɪə]", "heard [hɜːd]", "heard [hɜːd]"));
        mVerbsList.add(new Verbs(97,"поднимать тяжесть", "heave [hiːv]", "heaved [hiːvd]", "heaved [hiːvd]"));
        mVerbsList.add(new Verbs(98,"рубить","hew [hjuː]", "hewed [hjuːd]", "hewed [hjuːd]"));
        mVerbsList.add(new Verbs(99,"прятать", "hide [haɪd]", "hid [hɪd]", "hidden [ˈhɪdən]"));
        mVerbsList.add(new Verbs(100,"ударить", "hit [hɪt]", "hit [hɪt]", "hit [hɪt]"));
        mVerbsList.add(new Verbs(101,"держать", "hold [həʊld]", "held [held]", "held [held]"));
        mVerbsList.add(new Verbs(102,"причинить боль", "hurt [hɜːt]", "hurt [hɜːt]", "hurt [hɜːt]"));
        mVerbsList.add(new Verbs(103,"вкладывать", "inlay [ˌɪnˈleɪ]", "inlaid [ˌɪnˈleɪd]", "inlaid [ˌɪnˈleɪd]"));
        mVerbsList.add(new Verbs(104,"вводить", "input [ˈɪnpʊt]", "input [ˈɪnpʊt]", "input [ˈɪnpʊt]"));
        mVerbsList.add(new Verbs(105,"вставлять", "inset [ˌɪnˈset]", "inset [ˌɪnˈset]", "inset [ˌɪnˈset]"));
        mVerbsList.add(new Verbs(106,"вплетать", "interweave [ˌɪntəˈwiːv]", "interwove [ˌɪntəˈwəʊv]", "interwoven [ˌɪntəˈwəʊvən]"));
        mVerbsList.add(new Verbs(107,"хранить", "keep [kiːp]", "kept [kept]", "kept [kept]"));
        mVerbsList.add(new Verbs(108,"знать", "ken [ken]", "kenned [kend]", "kenned [kend]"));
        mVerbsList.add(new Verbs(109,"становиться на колени", "kneel  niːl]", "knelt [nelt]", "knelt [nelt]"));
        mVerbsList.add(new Verbs(110,"вязать", "knit [nɪt]", "knit [nɪt]", "knit [nɪt]"));
        mVerbsList.add(new Verbs(111,"знать", "know [nəʊ]", "knew [njuː]", "known [nəʊn]"));
        mVerbsList.add(new Verbs(112,"грузить", "lade  [leɪd]", "laded [ˈleɪdɪd]", "laded [ˈleɪdɪd]"));
        mVerbsList.add(new Verbs(113,"положить", "lay [leɪ]", "laid [leɪd]", "laid [leɪd]"));
        mVerbsList.add(new Verbs(114,"вести", "lead [liːd]", "led [led]", "led [led]"));
        mVerbsList.add(new Verbs(115,"операться", "lean [liːn]", "leant [lent]", "leant [lent]"));
        mVerbsList.add(new Verbs(116,"прыгать", "leap [liːp]", "leapt [lept]", "leapt [lept]"));
        mVerbsList.add(new Verbs(117,"учить", "learn [lɜːn]", "learnt [lɜːnt]", "learnt [lɜːnt]"));
        mVerbsList.add(new Verbs(118,"оставить", "leave [liːv]","left [left]", "left [left]"));
        mVerbsList.add(new Verbs(119,"одолжить", "lend [lend]", "lent [lent]", "lent [lent]"));
        mVerbsList.add(new Verbs(120,"позволять", "let [let]", "let [let]", "let [let]"));
        mVerbsList.add(new Verbs(121,"лежать", "lie [laɪ]", "lay [leɪ]", "lain [leɪn]"));
        mVerbsList.add(new Verbs(122,"осветить"," light [laɪt]", "lit [lɪt]","lit [lɪt]"));
        mVerbsList.add(new Verbs(123,"терять", "lose [luːz]", "lost [lɒst]", "lost [lɒst]"));
        mVerbsList.add(new Verbs(124,"делать", "make [ˈmeɪk]", "made [ˈmeɪd]", "made [ˈmeɪd]"));
        mVerbsList.add(new Verbs(125,"иметь возможность", "may [meɪ]", "might [maɪt]", "might [maɪt]"));
        mVerbsList.add(new Verbs(126,"подразумевать", "mean [miːn]", "meant [ment]", "meant [ment]"));
        mVerbsList.add(new Verbs(127,"встретить", "meet [miːt]", "met [met]", "met [met]"));
        mVerbsList.add(new Verbs(129,"поступать неправильно", "misdeal [ˌmɪsˈdiːl]", "misdealt [ˌmɪsˈdelt]", "misdealt [ˌmɪsˈdelt]"));
        mVerbsList.add(new Verbs(130,"внушать опасения", "misgive [ˌmɪsˈɡɪv]", "misgave [ˌmɪsˈɡeɪv]", "misgiven [ˌmɪsˈɡɪvən]"));
        mVerbsList.add(new Verbs(131,"ослышаться", "mishear [ˌmɪsˈhɪə]", "misheard [ˌmɪsˈhɪə]", "misheard [ˌmɪsˈhɪə]"));
        mVerbsList.add(new Verbs(132,"промахнуться", "mishit [ˈmɪshɪt]", "mishit [ˈmɪshɪt]", "mishit [ˈmɪshɪt]"));
        mVerbsList.add(new Verbs(133,"класть не на место", "mislay [ˌmɪsˈleɪ]", "mislaid [ˌmɪsˈleɪd]", "mislaid [ˌmɪsˈleɪd]"));
        mVerbsList.add(new Verbs(134,"ввести в заблуждение", "mislead [ˌmɪsˈliːd]", "misled [ˌmɪsˈled]", "misled [ˌmɪsˈled]"));

        mVerbsList.add(new Verbs(136,"писать с ошибками", "misspell [ˌmɪsˈspel]", "misspelt [ˌmɪsˈspelt]", "misspelt [ˌmɪsˈspelt]"));
        mVerbsList.add(new Verbs(137,"экономить", "misspend [ˌmɪsˈspend]", "misspent [ˌmɪsˈspent]", "misspent [ˌmɪsˈspent]"));
        mVerbsList.add(new Verbs(138,"неправильно понимать", "mistake [mɪˈsteɪk]", "mistook [mɪˈstʊk]", "mistaken [mɪˈsteɪkən]"));
        mVerbsList.add(new Verbs(139,"косить", "mow [maʊ]", "mowed [maʊd]", "mown [məʊn]"));
        mVerbsList.add(new Verbs(128,"ущипнуть", "nip [nip]", "nipped [nɪpt]", "nipt [nɪpt]"));
        mVerbsList.add(new Verbs(140,"перебивать цену", "outbid [aʊtˈbɪd]", "outbid [aʊtˈbɪd]", "outbid [aʊtˈbɪd]"));
        mVerbsList.add(new Verbs(141,"превосходить", "outdo [aʊtˈduː]", "outdid [aʊtˈdɪd]", "outdone [aʊtˈdʌn]"));
        mVerbsList.add(new Verbs(142,"побеждать (в бою)", "outfight [ˌaʊtˈfaɪt]", "outfought [ˌaʊtˈfɔːt]", "outfought [ˌaʊtˈfɔːt]"));
        mVerbsList.add(new Verbs(143,"вырастать из", "outgrow [ˌaʊtˈɡrəʊ]", "outgrew [ˌaʊtˈɡruː]", "outgrown [ˌaʊtˈɡrəʊn]"));
        mVerbsList.add(new Verbs(144,"выдавать", "output [ˈaʊtpʊt]", "output [ˈaʊtpʊt]", "output [ˈaʊtpʊt]"));
        mVerbsList.add(new Verbs(145,"опережать", "outrun [ˌaʊtˈrʌn]", "outran [ˌaʊtˈræn]", "outrun [ˌaʊtˈrʌn]"));
        mVerbsList.add(new Verbs(147,"затмевать", "outshine [ˌaʊtˈʃaɪn]", "outshone [ˌaʊtˈʃɒn]", "outshone [ˌaʊtˈʃɒn]"));
        mVerbsList.add(new Verbs(148,"перебивать цену", "overbid [ˌəʊvəˈbɪd]", "overbade [ˌəʊvəˈbeɪd]", "overbidden [ˌəʊvəˈbɪdən]"));
        mVerbsList.add(new Verbs(149,"преодолевать", "overcome [ˌəʊvəˈkʌm]", "overcame [ˌəʊvəˈkeɪm]", "overcome [ˌəʊvəˈkʌm]"));
        mVerbsList.add(new Verbs(150,"переусердствовать", "overdo [ˌəʊvəˈduː]", "overdid [ˌəʊvəˈdɪd]", "overdone [ˌəʊvəˈdʌn]"));
        mVerbsList.add(new Verbs(151,"превышать", "overdraw [ˌəʊvəˈdrɔː]", "overdrew [ˌəʊvəˈdruː]", "overdrawn [ˌəʊvəˈdrɔːn]"));
        mVerbsList.add(new Verbs(152,"объедаться", "overeat [ˌəʊvəˈriːt]", "overate [ˌəʊvəˈreɪt]", "overeaten [ˌəʊvəˈriːtən]"));
        mVerbsList.add(new Verbs(153,"перелетать", "overfly [ˌəʊvəˈflaɪ]", "overflew [ˌəʊvəˈfluː]", "overflown [ˌəʊvəˈfləʊn]"));
        mVerbsList.add(new Verbs(154,"нависать",  "overhang [ˌəʊvəˈhæŋ]", "overhung [ˌəʊvəˈhʌŋ]", "overhung [ˌəʊvəˈhʌŋ]"));
        mVerbsList.add(new Verbs(155,"подслушивать", "overhear [ˌəʊvəˈhɪə]", "overheard [ˌəʊvəˈhɜːd]", "overheard [ˌəʊvəˈhɜːd]"));
        mVerbsList.add(new Verbs(156,"покрывать", "overlay [ˌəʊvəˈleɪ]", "overlaid [ˌəʊvəˈleɪd]", "overlaid [ˌəʊvəˈleɪd]"));
        mVerbsList.add(new Verbs(157,"переплачивать", "overpay [ ˌəʊvəˈpeɪ ]", "overpaid [ˌəʊvəˈpeɪd]", "overpaid [ˌəʊvəˈpeɪd]"));
        mVerbsList.add(new Verbs(158,"отвергать", "override [ˌəʊvəˈraɪd]", "overrode [ˌəʊvəˈrəʊd]", "overridden [ˌəʊvəˈrɪdən]"));
        mVerbsList.add(new Verbs(159,"переливаться через край", "overrun [ˌəʊvəˈrʌn]", "overran [ˌəʊvəˈræn]", "overrun [ˌəʊvəˈrʌn]"));
        mVerbsList.add(new Verbs(160,"надзирать за", "oversee [ˌəʊvəˈsiː]", "oversaw [ˌəʊvəˈsɔː]", "overseen [ˌəʊvəˈsiːn]"));
        mVerbsList.add(new Verbs(161,"расстрелять", "overshoot [ˌəʊvəˈʃuːt]", "overshot [ˌəʊvəˈʃɒt]", "overshot [ˌəʊvəˈʃɒt]"));
        mVerbsList.add(new Verbs(162,"проспать", "oversleep [ˌəʊvəˈsliːp]", "overslept [ˌəʊvəˈslept]", "overslept [ˌəʊvəˈslept]"));
        mVerbsList.add(new Verbs(163,"догонять", "overtake [ˌəʊvəˈteɪk]", "overtook [ˌəʊvəˈtʊk]", "overtaken [ˌəʊvəˈteɪkən]"));
        mVerbsList.add(new Verbs(164,"свергать", "overthrow [ˌəʊvəˈθrəʊ]", "overthrew [ˌəʊvəˈθruː]", "overthrown [ˌəʊvəˈθrəʊn]"));
        mVerbsList.add(new Verbs(165,"вкушать", "partake [pɑːˈteɪk]", "partook [pɑːˈtʊk]", "partaken [pɑːˈteɪkən]"));
        mVerbsList.add(new Verbs(166,"платить", "pay [peɪ]", "paid [peɪd]", "paid [peɪd]"));
        mVerbsList.add(new Verbs(167,"обращаться к суду", "plead [pliːd]", "pleaded [ˈpliːdɪd]", "pleaded [ˈpliːdɪd]"));
        mVerbsList.add(new Verbs(168,"платить вперед", "prepay [ˌpriːˈpeɪ]", "prepaid [ˌpriːˈpeɪd]", "prepaid [ˌpriːˈpeɪd]"));
        mVerbsList.add(new Verbs(169,"доказывать, оказаться", "prove [pruːv]"," proved [pruːvd]", "proved [pruːvd]"));
        mVerbsList.add(new Verbs(170,"класть", "put [ˈpʊt]", "put [ˈpʊt]", "put [ˈpʊt]"));
        mVerbsList.add(new Verbs(171,"покидать, оставлять", "quit [kwɪt ]", "quit [kwɪt]", "quit [kwɪt]"));
        mVerbsList.add(new Verbs(172,"читать", "read [riːd]", "read [red]", "read [red]"));
        mVerbsList.add(new Verbs(173,"перевязывать", "rebind [ˌriːˈbaɪnd]", "rebound [rɪˈbaʊnd]", "rebound [rɪˈbaʊnd]"));
        mVerbsList.add(new Verbs(174,"перестроить", "rebuild [ˌriːˈbɪld]", "rebuilt [ˌriːˈbɪlt]", "rebuilt [ˌriːˈbɪlt]"));
        mVerbsList.add(new Verbs(175,"переделывать", "recast [ˌriːˈkɑːst ]", "recast [ˌriːˈkɑːst]", "recast [ˌriːˈkɑːst]"));
        mVerbsList.add(new Verbs(176,"повторять сделанное", "redo [ˌriːˈduː]","redid [ˌriːˈdɪd]", "redone [ˌriːˈdʌn]"));
        mVerbsList.add(new Verbs(177,"слушать вторично", "rehear [ˌriːˈhɪə]", "reheard [ˌriːˈhɜːd]", "reheard [ˌriːˈhɜːd]"));
        mVerbsList.add(new Verbs(178,"переделывать", "remake [ˌriːˈmeɪk]", "remade [ˌriːˈmeɪd]", "remade [ˌriːˈmeɪd]"));
        mVerbsList.add(new Verbs(179,"раздирать", "rend [rend]", "rent [rent]", "rent [rent]"));
        mVerbsList.add(new Verbs(180,"отдавать долг", "repay [rɪˈpeɪ]", "repaid [rɪˈpeɪd]", "repaid [rɪˈpeɪd]"));
        mVerbsList.add(new Verbs(181,"выполнять повторно", "rerun [ˈriːrʌn]", "reran [ˈriːræn]", "rerun [ˈriːrʌn]"));
        mVerbsList.add(new Verbs(182,"перепродавать", "resell [riːˈsel]", "resold [riːˈsəʊld]", "resold [riːˈsəʊld]"));
        mVerbsList.add(new Verbs(183,"возвращать", "reset [ˌriːˈset]", "reset [ˌriːˈset]", "reset [ˌriːˈset]"));
        mVerbsList.add(new Verbs(184,"забирать", "retake [ˌriːˈteɪk]", "retook [ˌriːˈtʊk]", "retaken [ˌriːˈteɪkən]"));
        mVerbsList.add(new Verbs(185,"пересказывать", "retell [ˌriːˈtel]", "retold [ˌriːˈtəʊld ]", "retold [ˌriːˈtəʊld]"));
        mVerbsList.add(new Verbs(186, "переписать", "rewrite [ˌriːˈraɪt ]", "rewrote [ˌriːˈrəʊt]", "rewritten [ˌriːˈrɪtən]"));
        mVerbsList.add(new Verbs(187,"избавлять", "rid [rɪd]", "rid [rɪd]", "rid [rɪd]"));
        mVerbsList.add(new Verbs(188,"ездить верхом", "ride [raɪd]", "rode [rəʊd]", "ridden [ˈrɪdən]"));
        mVerbsList.add(new Verbs(189,"звонить", "ring [rɪŋ]", "rang [ræŋ]", "rung [rʌŋ]"));
        mVerbsList.add(new Verbs(190,"подняться", "rise [raɪz]", "rose [rəʊz]", "risen [ˈrɪzən]"));
        mVerbsList.add(new Verbs(191,"расщеплять", "rive [raɪv]", "rived [raɪvd]", "riven [ˈrɪvən]"));
        mVerbsList.add(new Verbs(192,"бежать", "run [rʌn]", "ran [ræn]", "run [rʌn]"));
        mVerbsList.add(new Verbs(193,"пилить", "saw [ˈsɔː]", "sawed [ˈsɔːd]", "sawn [sɔːn]"));
        mVerbsList.add(new Verbs(194,"сказать", "say [ˈseɪ]", "said [ˈsed]", "said [ˈsed]"));
        mVerbsList.add(new Verbs(195,"видеть", "see [ˈsiː]", "saw [ˈsɔː]", "seen [ˈsiːn]"));
        mVerbsList.add(new Verbs(196,"искать", "seek [siːk]", "sought [ˈsɔːt]", "sought [ˈsɔːt]"));
        mVerbsList.add(new Verbs(197,"продавать", "sell [sel]", "sold [səʊld]", "sold [səʊld]"));
        mVerbsList.add(new Verbs(198,"послать", "send [send]", "sent [sent]", "sent [sent]"));
        mVerbsList.add(new Verbs(199,"устанавливать", "set [set]", "set [set]", "set [set]"));
        mVerbsList.add(new Verbs(200,"шить", "sew [səʊ]", "sewed [səʊd]", "sewed [səʊd]"));
        mVerbsList.add(new Verbs(201,"трясти", "shake [ʃeɪk]", "shook [ʃʊk]", "shaken [ˈʃeɪkən]"));
        mVerbsList.add(new Verbs(202,"брить", "shave [ʃeɪv]", "shaved [ʃeɪvd]", "shaved [ʃeɪvd]"));
        mVerbsList.add(new Verbs(203,"стричь", "shear [ʃɪə]", "sheared [ʃɪəd]", "shorn [ʃɔːn]"));
        mVerbsList.add(new Verbs(204,"проливать", "shed [ʃed]", "shed [ʃed]", "shed [ʃed]"));
        mVerbsList.add(new Verbs(205,"сиять", "shine [ʃaɪn]", "shone [ʃɒn]", "shone [ʃɒn]" ));
        mVerbsList.add(new Verbs(206,"обувать", "shoe [ʃuː]", "shod [ʃɒd]", "shod [ʃɒd]"));
        mVerbsList.add(new Verbs(207,"стрелять", "shoot [ʃuːt]", "shot [ʃɒt]", "shot [ʃɒt]"));
        mVerbsList.add(new Verbs(208,"показывать", "show [ʃəʊ]", "showed [ʃəʊd]", "shown [ʃəʊn]"));
        mVerbsList.add(new Verbs(209,"кромсать", "shred [ʃred]", "shred [ʃred]", "shred [ʃred]"));
        mVerbsList.add(new Verbs(210,"сжиматься", "shrink [ʃrɪŋk]", "shrank [ʃræŋk]", "shrunk [ʃrʌŋk]"));
        mVerbsList.add(new Verbs(211,"исповедовать", "shrive [ʃraɪv]", "shrove [ʃrəʊv]", "shriven [ˈʃrɪvən]"));
        mVerbsList.add(new Verbs(212,"закрывать", "shut [ʃʌt]", "shut [ʃʌt]", "shut [ʃʌt]"));
        mVerbsList.add(new Verbs(213,"петь", "sing [sɪŋ]", "sang [sæŋ]", "sung [sʌŋ]"));
        mVerbsList.add(new Verbs(214,"тонуть", "sink [sɪŋk]", "sank [sæŋk]", "sunk [sʌŋk]"));
        mVerbsList.add(new Verbs(215,"убивать", "slay [sleɪ]", "slew [sluː]", "slain [sleɪn]"));
        mVerbsList.add(new Verbs(216,"спать", "sleep [sliːp]", "slept [slept]", "slept [slept]"));
        mVerbsList.add(new Verbs(217,"скользить"," slide [slaɪd]", "slid [slɪd]", "slid [slɪd]"));
        mVerbsList.add(new Verbs(218,"швырять", "sling [səlɪŋ]", "slung [slʌŋ]", "slung [slʌŋ]"));
        mVerbsList.add(new Verbs(219,"красться", "slink [slɪŋk]", "slunk [slʌŋk]", "slunk [slʌŋk]"));
        mVerbsList.add(new Verbs(220,"разрезать", "slit [slɪt]", "slit [slɪt]", "slit [slɪt]"));
        mVerbsList.add(new Verbs(221,"пахнуть", "smell [smel]", "smelt [smelt]", "smelt [smelt]"));
        mVerbsList.add(new Verbs(222,"поражать", "smite [smaɪt]", "smote [sməʊt]", "smitten [smɪtən]"));
        mVerbsList.add(new Verbs(223,"сеять" , "sow [saʊ]", "sowed [səʊd]", "sowed [səʊd]"));
        mVerbsList.add(new Verbs(224,"говорить", "speak [spiːk]", "spoke [spəʊk]", "spoken [ˈspəʊkən]"));
        mVerbsList.add(new Verbs(225,"ускорять", "speed [spiːd]", "sped [sped]", "sped [sped]"));
        mVerbsList.add(new Verbs(226,"произносить по буквам","spell [spel]", "spelt [spelt]", "spell [spel]"));
        mVerbsList.add(new Verbs(227,"проводить", "spend [spend]", "spent [spent]", "spent [spent]"));
        mVerbsList.add(new Verbs(228,"пролить", "spill [spɪl]", "spilt [spɪlt]", "spilt [spɪlt]"));
        mVerbsList.add(new Verbs(229,"прясть", "spin [spɪn]", "spun [spʌn]", "spun [spʌn]"));
        mVerbsList.add(new Verbs(230,"плевать", "spit [spɪt]", "spat [spæt]", "spat [spæt]"));
        mVerbsList.add(new Verbs(231,"расщепить", "split [splɪt]", "split [splɪt]", "split [splɪt]"));
        mVerbsList.add(new Verbs(232,"портить", "spoil [spɔɪl]", "spoilt [spɔɪlt]", "spoilt [spɔɪlt]"));
        mVerbsList.add(new Verbs(233,"осветить", "spotlight [ˈspɒtlaɪt]", "spotlit [ˈspɒtlaɪt]", "spotlit [ˈspɒtlaɪt]	"));
        mVerbsList.add(new Verbs(233,"распространяться", "spread [spred]", "spread [spred]", "spread [spred]"));
        mVerbsList.add(new Verbs(234,"пружинить", "spring [sprɪŋ]", "sprang [spræŋ]", "sprung [sprʌŋ]"));
        mVerbsList.add(new Verbs(235,"стоять", "stand [stænd]", "stood [stʊd]", "stood [stʊd]"));
        mVerbsList.add(new Verbs(236,"проламывать", "stave [steɪv]", "staved [steɪvd]", "staved [steɪvd]"));
        mVerbsList.add(new Verbs(237,"украсть", "steal [stiːl]", "stole [stəʊl]", "stolen [ˈstəʊlən]"));
        mVerbsList.add(new Verbs(238,"придерживаться", "stick [stɪk]", "stuck [stʌk]", "stuck [stʌk]"));
        mVerbsList.add(new Verbs(239,"ужалить", "sting [stɪŋ]", "stung [stʌɡ]", "stung [stʌɡ]"));
        mVerbsList.add(new Verbs(240,"вонять", "stink [stɪŋk]", "stank [stæŋk]", "stunk [stʌŋk]"));
        mVerbsList.add(new Verbs(241,"посыпать", "strew [struː]", "strewed [struːd]", "strewn [struːn]"));
        mVerbsList.add(new Verbs(242,"шагать", "stride [straɪd]", "strode [strəʊd]", "stridden [ˈstrɪdən]"));
        mVerbsList.add(new Verbs(243,"разбивать", "strike [straɪk]", "struck [strʌk]", "struck [strʌk]"));
        mVerbsList.add(new Verbs(244,"натягивать", "string [strɪŋ]", "strung [strʌŋ]", "strung [strʌŋ]"));
        mVerbsList.add(new Verbs(245,"стараться", "strive [straɪv]", "strove [strəʊv]", "striven [ˈstrɪvən]"));
        mVerbsList.add(new Verbs(246,"передавать в субаренду", "sublet [ˌsʌbˈlet]", "sublet [ˌsʌbˈlet]", "sublet [ˌsʌbˈlet]"));
        mVerbsList.add(new Verbs(247,"клясться", "swear [sweə]", "swore [swɔː]", "sworn [swɔːn]"));
        mVerbsList.add(new Verbs(248,"мести", "sweep [swiːp]", "swept [swept]", "swept [swept]"));
        mVerbsList.add(new Verbs(249,"вздуться", "swell [swel]", "swelled [sweld]", "swollen [ˈswəʊlən]"));
        mVerbsList.add(new Verbs(250,"плыть", "swim [swɪm]", "swam [swæm]", "swum [swʌm]"));
        mVerbsList.add(new Verbs(251,"качаться", "swing [swɪŋ]", "swung [swʌŋ]", "swung [swʌŋ]"));
        mVerbsList.add(new Verbs(252,"взять", "take [teɪk]", "took [tʊk]", "taken [ˈteɪkən]"));
        mVerbsList.add(new Verbs(253,"учить", "teach [tiːtʃ]", "taught [tɔːt]", "taught [tɔːt]"));
        mVerbsList.add(new Verbs(254,"рвать", "tear [ˈteə]", "tore [ˈtɔː]", "torn [ˈtɔːn]"));
        mVerbsList.add(new Verbs(255,"рассказывать", "tell [tel]", "told [təʊld]", "told [təʊld]"));
        mVerbsList.add(new Verbs(256,"думать", "think [ˈθɪŋk]", "thought [ˈθɔːt]", "thought [ˈθɔːt]"));
        mVerbsList.add(new Verbs(257,"процветать", "thrive [θraɪv]", "throve [ˈθrəʊv]", "thriven [ˈθrɪvən]"));
        mVerbsList.add(new Verbs(258,"бросить"," throw [ˈθrəʊ]", "threw [θruː]", "thrown [ˈθrəʊn]"));
        mVerbsList.add(new Verbs(259,"толкнуть", "thrust [θrʌst]", "thrust [θrʌst]", "thrust [θrʌst]"));
        mVerbsList.add(new Verbs(260,"ступать", "tread [tred]"," trod [trɒd]", "trod [trɒd]"));
        mVerbsList.add(new Verbs(261,"разогнуть"," unbend [ˌʌnˈbend]", "unbent [ˌʌnˈbent]", "unbent [ˌʌnˈbent]"));
        mVerbsList.add(new Verbs(262,"снижать цену", "underbid [ˌʌndəˈbɪd]", "underbid [ˌʌndəˈbɪd]", "underbid [ˌʌndəˈbɪd]"));
        mVerbsList.add(new Verbs(263,"сбивать цены", "undercut [ˌʌndəˈkʌt]", "undercut [ˌʌndəˈkʌt]", "undercut [ˌʌndəˈkʌt]"));
        mVerbsList.add(new Verbs(264,"подвергаться", "undergo [ˌʌndəˈɡəʊ ]", "underwent [ˌʌndəˈwent]", "undergone [ˌʌndəˈɡɒn]"));
        mVerbsList.add(new Verbs(265,"лежать в основе", "underlie [ˌʌndəˈlaɪ]", "underlay [ˌʌndəˈleɪ]", "underlain [ˌʌndəˈleɪn]"));
        mVerbsList.add(new Verbs(267,"продавать дешевле", "undersell [ˌʌndəˈsel]", "undersold [ˌʌndəˈsəʊld]", "undersold [ˌʌndəˈsəʊld]"));
        mVerbsList.add(new Verbs(268,"понимать", "understand [ ˌʌndəˈstænd ]", "understood [ ˌʌndəˈstʊd ]", "understood [ˌʌndəˈstʊd]"));
        mVerbsList.add(new Verbs(269,"предпринять", "undertake [ˌʌndəˈteɪk]", "undertook [ˌʌndəˈtʊk]", "undertaken [ˌʌndəˈteɪkən]"));
        mVerbsList.add(new Verbs(270,"подписывать", "underwrite [ˌʌndəˈraɪt]", "underwrote [ˌʌndəˈrəʊt]", "underwritten [ˌʌndəˈrɪtən]"));
        mVerbsList.add(new Verbs(271,"уничтожать сделанное", "undo  [ʌnˈduː]", "undid [ʌnˈdɪd]", "undone [ʌnˈdʌn]"));
        mVerbsList.add(new Verbs(272,"размораживать", "unfreeze [ˌʌnˈfriːz]", "unfroze [ˌʌnˈfrəʊz]", "unfrozen [ˌʌnˈfrəʊzən]"));
        mVerbsList.add(new Verbs(273,"брать назад свои слова", "unsay [ˌʌnˈseɪ]", "unsaid [ˌʌnˈsed]", "unsaid [ˌʌnˈsed]"));
        mVerbsList.add(new Verbs(274,"развертывать", "unwind [ˌʌnˈwaɪnd]", "unwound [ˌʌnˈwaʊnd]", "unwound [ˌʌnˈwaʊnd]"));
        mVerbsList.add(new Verbs(275,"поддерживать", "uphold [ˌʌpˈhəʊld]", "upheld [ˌʌpˈheld]", "upheld [ˌʌpˈheld]"));
        mVerbsList.add(new Verbs(276,"опрокинуть, огорчить", "upset [ˌʌpˈset]", "upset [ˌʌpˈset]", "upset [ˌʌpˈset]"));
        mVerbsList.add(new Verbs(277,"просыпаться, будить", "wake [weɪk]", "woke [wəʊk]", "woken [ˈwəʊkən]"));
        mVerbsList.add(new Verbs(278,"подстерегать", "waylay [ˌweɪˈleɪ]", "waylaid [ˌweɪˈleɪd]", "waylaid [ˌweɪˈleɪd]"));
        mVerbsList.add(new Verbs(279,"носить", "wear [weə]", "wore [wɔː]", "worn [wɔːn]"));
        mVerbsList.add(new Verbs(280,"ткать", "weave [wiːv]", "wove [wəʊv]", "woven [ˈwəʊvən]"));
        mVerbsList.add(new Verbs(281,"выдавать замуж", "wed [wed]", "wed [wed]", "wed [wed]"));
        mVerbsList.add(new Verbs(282,"плакать", "weep [wiːp]", "wept [wept]", "wept [wept]"));
        mVerbsList.add(new Verbs(283,"мочить", "wet [wet]", "wet [wet]", "wet [wet]"));
        mVerbsList.add(new Verbs(284,"выиграть", "win [wɪn]", "won [wʌn]", "won [wʌn]"));
        mVerbsList.add(new Verbs(285,"заводить (механизм)", "wind [waɪnd]", "wound [waund]", "wound [waund]"));
        mVerbsList.add(new Verbs(286,"отозвать", "withdraw [wɪðˈdrɔː]", "withdrew [wɪðˈdruː]", "withdrawn [wɪðˈdrɔːn]"));
        mVerbsList.add(new Verbs(287,"удерживать", "withhold [wɪðˈhəʊld]", "withheld [wɪðˈheld]", "withheld [wɪðˈheld]"));
        mVerbsList.add(new Verbs(288,"противиться", "withstand [wɪðˈstænd]", "withstood [wɪðˈstʊd]", "withstood [wɪðˈstʊd]"));
        mVerbsList.add(new Verbs(289,"работать", "work [ˈwɜːk]", "worked [wɜːkt]", "worked [wɜːkt]"));
        mVerbsList.add(new Verbs(290,"скручивать", "wring [rɪŋ]", "wrung [rʌŋ]", "wrung [rʌŋ]"));
        mVerbsList.add(new Verbs(291,"писать", "write [ˈraɪt]", "wrote [rəʊt]", "written [ˈrɪtən]"));

        adapter = new VerbsListAdapter(getContext(), mVerbsList);
        listViewSearch.setAdapter(adapter);

        /*Обработка нажатий*/
        listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        /*Обработка нажатий*/

        /*Создание поиска*/
        searchViewSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String querty) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Verbs> results = new ArrayList<>();
                for(Verbs x: mVerbsList)
                {
                    if(x.firstFormElementary.contains(newText) | (x.secondFormElementary.contains((newText)) |
                            (x.thirdFormElementary.contains(newText)) | (x.transfer.contains(newText))))
                        results.add(x);
                }
                ((VerbsListAdapter)listViewSearch.getAdapter()).update(results);

                /*Окончание поиска*/

                return false;
            }
        });

        return view;
    }
}
