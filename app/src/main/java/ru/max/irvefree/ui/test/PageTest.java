package ru.max.irvefree.ui.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import ru.max.irvefree.R;

public class PageTest extends AppCompatActivity implements View.OnClickListener {

    private TextView qCount, questionLabel, tvRightAnswer, tvWrongAnswer;
    private Button answer1, answer2, answer3, answer4;
    private List<Question> questionList;
    private int quesNum;
    private int score;
    private int level_id;
    private int rAns, wAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_test);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_gradient));
        //Надпись в верху
        String title = getIntent().getStringExtra("LEVEL");
        getSupportActionBar().setTitle(title);
        //Возвратная кнопка
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Получение id списка
        level_id = getIntent().getIntExtra("LEVEL_ID", 1);

        tvRightAnswer = (TextView) findViewById(R.id.tvRightAnswer);
        tvWrongAnswer = (TextView) findViewById(R.id.tvWrongAnswer);

        qCount = (TextView) findViewById(R.id.quest_num);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);

        getQuestionList();
        score = 0;

    }

    ;

    private void getQuestionList() {
        questionList = new ArrayList<>();

        if (level_id == 1) {
            questionList.add(new Question("Идти", "do, did, done", "go, went, gone", "beat, beat, beat", "break, broke, broken", 2));
            questionList.add(new Question("Быть", "be, was/were, been", "beat, beat, beat", "go, went, gone", "chose, choose, chosen", 1));
            questionList.add(new Question("Начинать", "blow, blew, blown", "drive, drove, driven", "begin, began, begun", "break, broke, broken", 3));
            questionList.add(new Question("Ломать", "break, broke, broken", "build, built, built", "become, became, become", "burn, burnt, burnt", 1));
            questionList.add(new Question("Покупать", "buy, bought, bought", "find, found, found", "go, went, gone", "brake, broke, broken", 1));
            questionList.add(new Question("Пить, выпить", "be, was/were, been", "drink, drank, drunk", "come, came, come", "chose, choose, chosen", 2));
            questionList.add(new Question("Стоить", "creep, crept, crept", "cut, cut, cut", "cost, cost, cost", "get, got, got", 3));
            questionList.add(new Question("Делать", "do, did, done", "go, went, gone", "drive, drove, driven", "brake, broke, broken", 1));
            questionList.add(new Question("Резать", "drive, drove, driven", "do, did, done", "get, got, got", "cut, cut, cut", 4));
            questionList.add(new Question("Рисовать", "learn, learnt, learnt", "draw, drew, drawn", "write, wrote, written", "fly, flew, flown", 2));
            questionList.add(new Question("Водить", "drive, drove, driven", "meet, met, met", "know, knew, known", "beat, beat, beat", 1));
            questionList.add(new Question("Есть", "hear, heard, heard", "cut, cut, cut", "eat, ate, eaten", "brake, broke, broken", 3));
            questionList.add(new Question("Чувствовать", "feel, felt, felt", "build, built, built", "drink, drank, drunk", "creep, crept, crept", 1));
            questionList.add(new Question("Находить", "find, found, found", "blow, blew, blown", "buy, bought, bought", "meet, met, met", 1));
            questionList.add(new Question("Летать", "forget, forgot, forgotten", "go, went, gone", "meet, met, met", "fly, flew, flown", 4));
            questionList.add(new Question("Забывать", "understand, understood, understood", "forget, forgot, forgotten", "come, came, come", "brake, broke, broken", 2));
            questionList.add(new Question("Получать", "get, got, got", "buy, bought, bought", "hear, heard, heard", "be, was/were, been", 1));
            questionList.add(new Question("Иметь", "write, wrote, written", "meet, met, met", "cut, cut, cut", "have, had, had", 4));
            questionList.add(new Question("Слышать", "build, built, built", "drink, drank, drunk", "hear, heard, heard", "find, found, found", 3));
            questionList.add(new Question("Знать", "know, knew, known", "write, wrote, written", "fly, flew, flown", "brake, broke, broken", 1));
            questionList.add(new Question("Учить", "beat, beat, beat", "learn, learnt, learnt", "chose, choose, chosen", "hear, heard, heard", 2));
            questionList.add(new Question("Встречать", "meet, met, met", "fly, flew, flown", "buy, bought, bought", "write, wrote, written", 1));
            questionList.add(new Question("Писать", "blow, blew, blown", "be, was/were, been", "drink, drank, drunk", "write, wrote, written", 4));
            questionList.add(new Question("Понимать", "forget, forgot, forgotten", "understand, understood, understood", "catch, caught, caught", "know, knew, known", 2));
            questionList.add(new Question("Приходить", "creep, crept, crept", "break,broke, broken", "come, came, come", "forget, forgot, forgotten", 3));
        }
        if (level_id == 2) {
            questionList.add(new Question("Становиться", "sleep, slept, slept", "bite, bit, bit", "become, became, become", "see, saw, seen", 3));
            questionList.add(new Question("Ловить", "catch, caught, caught", "lose, lost, lost", "get, got, got", "read, read, read", 1));
            questionList.add(new Question("Принести", "sit, sat, sat", "bring, brought, brought", "run, ran, run", "ride, rode, ridden", 2));
            questionList.add(new Question("Строить", "read, read, read", "build, built, built", "put, put, put", "pay, paid, paid", 2));
            questionList.add(new Question("Мочь, уметь", "make, made, made", "lose, lost, lost", "speak, spoke, spoken", "can, could, been able", 4));
            questionList.add(new Question("Выбрать", "grow, grew, grown", "put, put, put", "choose, chose, chosen", "lose, lost, lost", 3));
            questionList.add(new Question("Кормить", "fight, fought, fought", "feed, fed, fed", "bite, bit, bit", "catch, caught, caught", 2));
            questionList.add(new Question("Падать", "bring, brought, brought", "see, saw, seen", "leave, left, left", "fall, fell, fallen", 4));
            questionList.add(new Question("Сражаться, драться", "fight, fought, fought", "make, made, made", "can, could, been able", "bite, bit, bit", 1));
            questionList.add(new Question("Дать", "pay, paid, paid", "get, got, got", "give, gave, given", "find, found, found", 3));
            questionList.add(new Question("Расти", "build, built, built", "grow, grew, grown", "creep, crept, crept", "bite, bit, bit", 2));
            questionList.add(new Question("Говорить", "say, said, said", "know, knew, known", "read, read, read", "speak, spoke, spoken", 4));
            questionList.add(new Question("Причинить боль", "hurt, hurt, hurt", "fight, fought, fought", "pay, paid, paid", "blow, blew, blown", 1));
            questionList.add(new Question("Оставить", "leave, left, left", "go, went, gone", "bring, brought, brought", "lose, lost, lost", 1));
            questionList.add(new Question("Терять", "grow, grew, grown", "learn, learnt, learnt", "lose, lost, lost", "cut, cut, cut", 3));
            questionList.add(new Question("Делать", "put, put, put", "run, ran, run", "build, built, built", "make, made, made", 4));
            questionList.add(new Question("Платить", "cost, cost, cost", "pay, paid, paid", "buy, bought, bought", "get, got, got", 2));
            questionList.add(new Question("Класть", "read, read, read", "sit, sat, sat", "put, put, put", "sleep, slept, slept", 3));
            questionList.add(new Question("Читать", "grow, grew, grown", "read, read, read", "run, ran, run", "bring, brought, brought", 2));
            questionList.add(new Question("Ездить верхом", "ride, rode, ridden", "go, went, gone", "drive, drove, driven", "come, came, come", 1));
            questionList.add(new Question("Бежать, владеть", "have, had, had", "creep, crept, crept", "pay, paid, paid", "run, ran, run", 4));
            questionList.add(new Question("Сказать", "know, knew, known", "say, said, said", "learn, learnt, learnt", "choose, chose, chosen", 2));
            questionList.add(new Question("Видеть", "see, saw, seen", "blow, blew, blown", "give, gave, given", "hear, heard, heard", 1));
            questionList.add(new Question("Спать", "forget, forgot, forgotten", "fly, flew, flown", "sleep, slept, slept", "draw, drew, drawn", 3));
            questionList.add(new Question("Кусать", "break, broke, broken", "fight, fought, fought", "bite, bit, bit", "grow, grew, grown", 3));
        }
        if (level_id == 3) {
            questionList.add(new Question("Ударить, попасть", "shear, sheared, shorn", "awake, awoke, awoken", "hit, hit, hit", "reset, reset, reset", 3));
            questionList.add(new Question("Подняться", "arise, arose, arisen", "reset, reset, reset", "remake, remade, remade", "stand, stood, stood", 1));
            questionList.add(new Question("Родиться", "hold, held, held", "dig, dug, dug", "bear, bore, born", "breed, bred, bred", 3));
            questionList.add(new Question("Бить", "dive, dived, dived", "steal, stole, stolen", "take, took, taken", "beat, beat, beaten", 4));
            questionList.add(new Question("Дуть", "rise, rose, risen", "blow, blew, blown", "light, lit, lit", "shake, shook, shaken", 2));
            questionList.add(new Question("Выращивать, разводить", "breed, bred, bred", "prove, proved, proved", "leap, leapt, leapt", "awake, awoke, awoken", 1));
            questionList.add(new Question("Жечь, гореть", "burn, burnt, burnt", "seek, sought, sought", "keep, kept, kept", "stand, stood, stood", 1));
            questionList.add(new Question("Копать", "lie, lay, lain", "dig, dug, dug", "work, worked, worked", "hold, held, held", 2));
            questionList.add(new Question("Нырять, погружаться", "set, set, set", "tell, told, told", "dive, dived, dived", "forecast, forecast, forecast", 3));
            questionList.add(new Question("Грезить, мечтать", "sew, sewed, sewed", "quit, quit, quit", "win, won, won", "dream, dreamt, dreamt", 4));
            questionList.add(new Question("Простить", "forget, forgot, forgotten", "forgive, forgave, forgiven", "take, took, taken", "think, thought, thought", 2));
            questionList.add(new Question("Замерзнуть, замораживать", "wear, wore, worn", "seek, sought, sought", "swim, swam, swum", "freeze, froze, frozen", 4));
            questionList.add(new Question("Висеть, повесить", "hang, hung, hung", "hold, held, held", "shake, shook, shaken", "sell, sold, sold", 1));
            questionList.add(new Question("Прятать", "teach, taught, taught", "light, lit, lit", "hide, hid, hidden", "shear, sheared, shorn", 3));
            questionList.add(new Question("Держать", "stand, stood, stood", "ring, rang, rung", "hold, held, held", "take, took, taken", 3));
            questionList.add(new Question("Вводить (информацию)", "dig, dug, dug", "input, input, input", "tell, told, told", "win, won, won", 2));
            questionList.add(new Question("Хранить", "keep, kept, kept", "hit, hit, hit", "arise, arose, arisen", "breed, bred, bred", 1));
            questionList.add(new Question("Прыгать", "blow, blew, blown", "leap, leapt, leapt", "beat, beat, beaten", "hang, hung, hung", 2));
            questionList.add(new Question("Лежать", "breed, bred, bred", "burn, burnt, burnt", "lie, lay, lain", "send, sent, sent", 3));
            questionList.add(new Question("Мочь, иметь возможность", "hold, held, held", "dream, dreamt, dreamt", "blow, blew, blown", "may, might, might", 4));
            questionList.add(new Question("Подразумевать", "forgive, forgave, forgiven", "freeze, froze, frozen", "mean, meant, meant", "hold, held, held", 3));
            questionList.add(new Question("Работать", "work, worked, worked", "arise, arose, arisen", "leap, leapt, leapt", "arise, arose, arisen", 1));
            questionList.add(new Question("Выполнять повторно", "hit, hit, hit", "send, sent, sent", "blow, blew, blown", "rerun, reran, rerun", 4));
            questionList.add(new Question("Звонить", "burn, burnt, burnt", "ring, rang, rung", "breed, bred, bred", "teach, taught, taught", 2));
            questionList.add(new Question("Искать", "seek, sought, sought", "beat, beat, beaten", "shave, shaved, shaved", "forgive, forgave, forgiven", 1));
            questionList.add(new Question("Продавать", "ring, rang, rung", "leap, leapt, leapt", "breed, bred, bred", "sell, sold, sold", 4));
            questionList.add(new Question("Устанавливать", "hang, hung, hung", "set, set, set", "hold, held, held", "stand, stood, stood", 2));
            questionList.add(new Question("Послать, отправить", "win, won, won", "shave, shaved, shaved", "send, sent, sent", "blow, blew, blown", 3));
            questionList.add(new Question("Петь", "sing, sang, sung", "dream, dreamt, dreamt", "hit, hit, hit", "ring, rang, rung", 1));
            questionList.add(new Question("Стоять", "teach, taught, taught", "stand, stood, stood", "hang, hung, hung", "forgive, forgave, forgiven", 2));
            questionList.add(new Question("Украсть", "blow, blew, blown", "breed, bred, bred", "arise, arose, arisen", "steal, stole, stolen", 4));
            questionList.add(new Question("Плыть", "freeze, froze, frozen", "breed, bred, bred", "burn, burnt, burnt", "swim, swam, swum", 4));
            questionList.add(new Question("Взять, брать", "take, took, taken", "may, might, might", "hit, hit, hit", "beat, beat, beaten", 1));
            questionList.add(new Question("Учить", "stand, stood, stood", "arise, arose, arisen", "teach, taught, taught", "hold, held, held", 3));
            questionList.add(new Question("Рассказывать, сказать", "beat, beat, beaten", "tell, told, told", "forgive, forgave, forgiven", "dream, dreamt, dreamt", 2));
            questionList.add(new Question("Думать", "think, thought, thought", "hold, held, held", "may, might, might", "arise, arose, arisen", 1));
            questionList.add(new Question("Носить (одежду)", "forgive, forgave, forgiven", "hang, hung, hung", "wear, wore, worn", "breed, bred, bred", 3));
            questionList.add(new Question("Выиграть", "shave, shaved, shaved", "freeze, froze, frozen", "leap, leapt, leapt", "win, won, won", 4));
            questionList.add(new Question("Предсказывать", "forecast, forecast, forecast", "beat, beat, beaten", "hit, hit, hit", "ring, rang, rung", 1));
            questionList.add(new Question("Опереться, прислониться", "breed, bred, bred", "leap, leapt, leapt", "lean, leant, leant", "teach, taught, taught", 3));
            questionList.add(new Question("Светить", " light, lit, lit", "win, won, won", "send, sent, sent", "may, might, might", 1));
            questionList.add(new Question("Доказывать, оказаться", "hold, held, held", "blow, blew, blown", "shave, shaved, shaved", "prove, proved, proved", 4));
            questionList.add(new Question("Покидать, оставлять", "hit, hit, hit", "quit, quit, quit", "may, might, might", "beat, beat, beaten", 2));
            questionList.add(new Question("Возвращать", "reset, reset, reset", "burn, burnt, burnt", "win, won, won", "beat, beat, beaten", 1));
            questionList.add(new Question("Подняться", "breed, bred, bred", "arise, arose, arisen", "breed, bred, bred", "rise, rose, risen", 4));
            questionList.add(new Question("Шить", "beat, beat, beaten", "forgive, forgave, forgiven", "sew, sewed, sewed", "freeze, froze, frozen", 3));
            questionList.add(new Question("Трясти", "burn, burnt, burnt", "shake, shook, shaken", "hang, hung, hung", "blow, blew, blown", 2));
            questionList.add(new Question("Брить", "dream, dreamt, dreamt", "beat, beat, beaten", "shave, shaved, shaved", "breed, bred, bred", 3));
            questionList.add(new Question("Стричь", "hit, hit, hit", "arise, arose, arisen", "shear, sheared, shorn", "hold, held, held", 3));
            questionList.add(new Question("Проснуться", "awake, awoke, awoken", "breed, bred, bred", "forgive, forgave, forgiven", "hang, hung, hung", 1));
        }
        if (level_id == 4) {
            questionList.add(new Question("Пребывать", "bless, blessed, blessed", "rebind, rebound, rebound", "abide, abode, abode", "shine, shone, shone", 3));
            questionList.add(new Question("Порождать", "deal, dealt, dealt", "lay, laid, laid", "beget, begot, begotten", "rid, rid, rid", 3));
            questionList.add(new Question("Опоясывать ", "cleave, clove, cloven", "begird, begirt, begirt", "shoe, shod, shod", "saw, sawed, sawn", 2));
            questionList.add(new Question("Зреть", "forbid, forbad, forbidden", "inset, inset, inset", "behold, beheld, beheld", "spill, spilt, spilt", 3));
            questionList.add(new Question("Гнуть", "bend, bent, bent", "lade, laded, laded", "strike, struck, struck", "shoot, shot, shot", 1));
            questionList.add(new Question("Умолять, упрашивать", "forsake, forsook, forsaken", "shed, shed, shed", "lend, lent, lent", "beseech, besought ,besought", 4));
            questionList.add(new Question("Связать", "bind, bound, bound", "spill, spilt, spilt", "shine, shone, shone", "lay, laid, laid", 1));
            questionList.add(new Question("Кровоточить", "bleed, bled, bled", "abide, abode, abode", "inset, inset, inset", "shut, shut, shut", 1));
            questionList.add(new Question("Благословлять", "forswear, forswore, forsworn ", "bless, blessed, blessed", "begird, begirt, begirt", "show, showed, shown", 2));
            questionList.add(new Question("Рассечь", " grind, ground, ground", "shoot, shot, shot", "cleave, clove, cloven", "shed, shed, shed", 3));
            questionList.add(new Question("Ползти", "creep, crept, crept", "bend, bent, bent", "lade, laded, laded", "smell, smelt, smelt", 1));
            questionList.add(new Question("Иметь дело", "heave, heaved, heaved", "shoe, shod, shod", "rebind, rebound, rebound", "deal, dealt, dealt", 4));
            questionList.add(new Question("Запретить", "lend, lent, lent", "bleed, bled, bled", "forbid, forbad, forbidden", "slide, slid, slid", 3));
            questionList.add(new Question("Покидать", "mow, mowed, mown", "forsake, forsook, forsaken", "saw, sawed, sawn", "stick, stuck, stuck", 2));
            questionList.add(new Question("Отрекаться", "abide, abode, abode", "beget, begot, begotten", "bless, blessed, blessed", "forswear, forswore, forsworn", 4));
            questionList.add(new Question("Точить, молоть", "behold, beheld, beheld", "rid, rid, rid", "spoil, spoilt, spoilt", "grind, ground, ground", 4));
            questionList.add(new Question("Подымать", "begird, begirt, begirt", "cleave, clove, cloven", "heave, heaved, heaved", "smell, smelt, smelt", 3));
            questionList.add(new Question("Вставлять, вкладывать", "inset, inset, inset", "bind, bound, bound", "shed, shed, shed", "strike, struck, struck", 1));
            questionList.add(new Question("Грузить", "lade, laded, laded", "spill, spilt, spilt", "shoot, shot, shot", "shut, shut, shut", 1));
            questionList.add(new Question("Класть, положить", "beseech, besought ,besought", "forsake, forsook, forsaken", "show, showed, shown", "lay, laid, laid", 4));
            questionList.add(new Question("Одолжить", "stick, stuck, stuck", "lend, lent, lent", "bleed, bled, bled", "swear, swore, sworn", 2));
            questionList.add(new Question("Косить", "shoe, shod, shod", "creep, crept, crept", "mow, mowed, mown", "bless, blessed, blessed", 3));
            questionList.add(new Question("Перевязывать", "rebind, rebound, rebound", "deal, dealt, dealt", "bend, bent, bent", "spill, spilt, spilt", 1));
            questionList.add(new Question("Избавлять", "rid, rid, rid", "forswear, forswore, forsworn", "beget, begot, begotten", "spoil, spoilt, spoilt", 1));
            questionList.add(new Question("Пилить", "throw, threw, thrown", "saw, sawed, sawn", "swear, swore, sworn", "lade, laded, laded", 2));
            questionList.add(new Question("Проливать", "shed, shed, shed", "behold, beheld, beheld", "spoil, spoilt, spoilt", "spill, spilt, spilt", 1));
            questionList.add(new Question("Светить, сиять", "smell, smelt, smelt", "forbid, forbad, forbidden", "forsake, forsook, forsaken", "shine, shone, shone", 4));
            questionList.add(new Question("Обувать, подковывать", "strike, struck, struck", "grind, ground, ground", "stick, stuck, stuck", "shoe, shod, shod", 4));
            questionList.add(new Question("Стрелять, давать побеги", "lade, laded, laded", "shoot, shot, shot", "bind, bound, bound", "lend, lent, lent", 2));
            questionList.add(new Question("Показывать", "spill, spilt, spilt", "heave, heaved, heaved", "show, showed, shown", "begird, begirt, begirt", 3));
            questionList.add(new Question("Закрывать", "rebind, rebound, rebound", "beseech, besought ,besought", "shut, shut, shut", "inset, inset, inset", 3));
            questionList.add(new Question("Скользить", " slide, slid, slid", "mow, mowed, mown", "deal, dealt, dealt", "lade, laded, laded", 1));
            questionList.add(new Question("Пахнуть, нюхать", "saw, sawed, sawn", "smell, smelt, smelt", "abide, abode, abode", "forsake, forsook, forsaken", 2));
            questionList.add(new Question("Писать или читать по буквам", "spell, spelt, spell", "swear, swore, sworn", "forswear, forswore, forsworn", "bend, bent, bent", 1));
            questionList.add(new Question("Пролить", "beget, begot, begotten", "spill, spilt, spilt", "forbid, forbad, forbidden", "throw, threw, thrown", 2));
            questionList.add(new Question("Портить", "show, showed, shown", "shine, shone, shone", "creep, crept, crept", "spoil, spoilt, spoilt", 4));
            questionList.add(new Question("Уколоть, приклеить", "lay, laid, laid", "shoot, shot, shot", "shoe, shod, shod", "stick, stuck, stuck", 4));
            questionList.add(new Question("Ударить, бить, бастовать", "shine, shone, shone", "strike, struck, struck", "behold, beheld, beheld", "heave, heaved, heaved", 2));
            questionList.add(new Question("Клясться, браниться", "swear, swore, sworn", "rebind, rebound, rebound", "grind, ground, ground", "cleave, clove, cloven", 1));
            questionList.add(new Question("Рвать", "bless, blessed, blessed", "saw, sawed, sawn", "tear, tore, torn", "bleed, bled, bled", 3));
            questionList.add(new Question("Бросить", "forsake, forsook, forsaken", "throw, threw, thrown", "rid, rid, rid", "bind, bound, bound", 2));
            questionList.add(new Question("Просыпаться, будить", "begird, begirt, begirt", "lade, laded, laded", "wake, woke, woken", "deal, dealt, dealt", 3));
            questionList.add(new Question("Подстерегать", "waylay, waylaid, waylaid", "shed, shed, shed", "beseech, besought ,besought", "mow, mowed, mown", 1));
            questionList.add(new Question("Выдавать замуж", "wed, wed, wed", "heave, heaved, heaved", "inset, inset, inset", "slide, slid, slid", 1));
            questionList.add(new Question("Плакать", "bind, bound, bound", "cleave, clove, cloven", "weep, wept, wept", "beget, begot, begotten", 3));
            questionList.add(new Question("Мочить, увлажнять", "deal, dealt, dealt", "wet, wet, wet", "mow, mowed, mown", "show, showed, shown", 2));
            questionList.add(new Question("Заводить (механизм)", "bend, bent, bent", "wind, wound, wound", "forbid, forbad, forbidden", "creep, crept, crept", 2));
            questionList.add(new Question("Противиться", "withstand, withstood, withstood", "lend, lent, lent", "lay, laid, laid", "rid, rid, rid", 1));
            questionList.add(new Question("Скрутить, сжать", "wring, wrung, wrung", "forswear, forswore, forsworn", "grind, ground, ground", "beseech, besought ,besought", 1));
            questionList.add(new Question("Лишать", "behold, beheld, beheld", "abide, abode, abode", "bleed, bled, bled", "bereave, bereft, bereft", 4));
        }
        if (level_id == 5) {
            questionList.add(new Question("Отпадать", "forbear, forbore, forborne", "rive, rived, riven", "backslide, backslid, backslid", "inlay, inlaid, inlaid", 3));
            questionList.add(new Question("Случиться ", "befall, befell, befallen", "gainsay, gainsaid, gainsaid", "partake, partook, partaken", "shred, shred, shred", 1));
            questionList.add(new Question("Лишать", "bereave, bereft, bereft", "interweave, interwove, interwoven", "knit,  knit, knit", "shrink, shrank, shrunk", 1));
            questionList.add(new Question("Заказывать", "rend, rent, rent", "bespeak, bespoke, bespoke", "lead, led, led", "sink, sank, sunk", 2));
            questionList.add(new Question("Садиться, сидеть верхом", "recast, recast, recast ", "bestride, bestrode, bestridden", "smite, smote, smitten", "slink, slunk, slunk", 2));
            questionList.add(new Question("Держать пари", "bet, bet, bet", "sling, slung, slung", "speed, sped, sped", "slay, slew, slain", 1));
            questionList.add(new Question("Велеть, просить", "sow, sowed, sowed", "bid, bad, bid", "let, let , let", "ken, kenned, kenned", 2));
            questionList.add(new Question("Вещать (по ТВ, радио)", "backslide, backslid, backslid", "spit, spat, spat", "stride, strode, stridden", "broadcast, broadcast, broadcast", 4));
            questionList.add(new Question("Разразиться, взорваться", "rive, rived, riven", "recast, recast, recast", "spin, spun, spun", "burst, burst, burst", 4));
            questionList.add(new Question("Разжаловать, уничтожить", "bust, bust, bust", "sink, sank, sunk", "split, split, split", "swing, swung, swung", 1));
            questionList.add(new Question("Бранить", "chide, chid, chid", "lead, led, led", "knit,  knit, knit", "slit, slit, slit", 1));
            questionList.add(new Question("Сметь", "dare, durst, dared", "partake, partook, partaken", "sweep, swept, swept", "thrust, thrust, thrust", 1));
            questionList.add(new Question("Бросить", "shred, shred, shred", "shrink, shrank, shrunk", "rend, rent, rent", "fling, flung, flung", 4));
            questionList.add(new Question("Воздерживаться", "let, let , let", "forbear, forbore, forborne", "sow, sowed, sowed", "speed, sped, sped", 2));
            questionList.add(new Question("Отрицать, противоречить", "gainsay, gainsaid, gainsaid", "bereave, bereft, bereft", "strive, strove, striven", "upset, upset, upset", 1));
            questionList.add(new Question("Опоясывать", "slink, slunk, slunk", "bet, bet, bet", "slay, slew, slain", "gird, girded, girded", 4));
            questionList.add(new Question("Вкладывать, выстилать", "sling, slung, slung", "smite, smote, smitten", "inlay, inlaid, inlaid", "weave, wove, woven", 3));
            questionList.add(new Question("Вплести, воткать", "bespeak, bespoke, bespoke", "interweave, interwove, interwoven", "stride, strode, stridden", "sting, stung, stung", 2));
            questionList.add(new Question("Знать, узнавать по виду", "ken, kenned, kenned", "string, strung, strung", "swing, swung, swung", "sow, sowed, sowed", 1));
            questionList.add(new Question("Вязать", "bestride, bestrode, bestridden", "befall, befell, befallen", "spit, spat, spat", "knit,  knit, knit", 4));
            questionList.add(new Question("Вести", "bid, bad, bid", "chide, chid, chid", "lead, led, led", "split, split, split", 3));
            questionList.add(new Question("Пустить, дать", "slit, slit, slit", "bust, bust, bust", "fling, flung, flung", "let, let , let", 4));
            questionList.add(new Question("Вкушать", "broadcast, broadcast, broadcast", "partake, partook, partaken", "thrust, thrust, thrust", "upset, upset, upset", 2));
            questionList.add(new Question("Видоизменять, преобразовывать", "spin, spun, spun", "recast, recast, recast", "speed, sped, sped", "weave, wove, woven", 2));
            questionList.add(new Question("Раздирать", "rend, rent, rent", "dare, durst, dared", "bereave, bereft, bereft", "sweep, swept, swept", 1));
            questionList.add(new Question("Расщеплять", "rive, rived, riven", "stride, strode, stridden", "gainsay, gainsaid, gainsaid", "string, strung, strung", 1));
            questionList.add(new Question("Кромсать, расползаться", "strive, strove, striven", "shred, shred, shred", "gainsay, gainsaid, gainsaid", "thrust, thrust, thrust", 2));
            questionList.add(new Question("Сокращаться, сжиматься", "smite, smote, smitten", "forbear, forbore, forborne", "shrink, shrank, shrunk", "swing, swung, swung", 3));
            questionList.add(new Question("Тонуть", "sink, sank, sunk", "inlay, inlaid, inlaid", "bet, bet, bet", "spin, spun, spun", 1));
            questionList.add(new Question("Убивать", "speed, sped, sped", "backslide, backslid, backslid", "bust, bust, bust", "slay, slew, slain", 4));
            questionList.add(new Question("Швырять, подвешивать", "sweep, swept, swept", "bestride, bestrode, bestridden", "split, split, split", "sling, slung, slung", 4));
            questionList.add(new Question("Идти крадучись", "string, strung, strung", "broadcast, broadcast, broadcast", "slink, slunk, slunk", "spit, spat, spat", 3));
            questionList.add(new Question("Разрезать (вдоль)", "interweave, interwove, interwoven", "bid, bad, bid", "chide, chid, chid", "slit, slit, slit", 4));
            questionList.add(new Question("Ударять, разбивать", "partake, partook, partaken", "smite, smote, smitten", "bust, bust, bust", "rend, rent, rent", 2));
            questionList.add(new Question("Сеять", "shrink, shrank, shrunk", "shred, shred, shred", "sow, sowed, sowed", "strive, strove, striven", 3));
            questionList.add(new Question("Ускорять, спешить", "speed, sped, sped", "bespeak, bespoke, bespoke", "slay, slew, slain", "gainsay, gainsaid, gainsaid", 1));
            questionList.add(new Question("Прясть", "let, let , let", "spin, spun, spun", "dare, durst, dared", "slit, slit, slit", 2));
            questionList.add(new Question("Плевать", "gainsay, gainsaid, gainsaid", "recast, recast, recast", "sling, slung, slung", "spit, spat, spat", 4));
            questionList.add(new Question("Расщепить", "split, split, split", "rend, rent, rent", "sink, sank, sunk", "bust, bust, bust", 1));
            questionList.add(new Question("Шагать", "stride, strode, stridden", "fling, flung, flung", "befall, befell, befallen", "slink, slunk, slunk", 1));
            questionList.add(new Question("Нанизать, натянуть", "inlay, inlaid, inlaid", "slay, slew, slain", "string, strung, strung", "chide, chid, chid", 3));
            questionList.add(new Question("Стараться", "rive, rived, riven", "strive, strove, striven", "interweave, interwove, interwoven", "bereave, bereft, bereft", 2));
            questionList.add(new Question("Мести, промчаться", "ken, kenned, kenned", "sweep, swept, swept", "shred, shred, shred", "bust, bust, bust", 2));
            questionList.add(new Question("Качаться", "sink, sank, sunk", "shrink, shrank, shrunk", "lead, led, led", "swing, swung, swung", 4));
            questionList.add(new Question("Толкнуть, сунуть", "partake, partook, partaken", "let, let , let", "forbear, forbore, forborne", "thrust, thrust, thrust", 4));
            questionList.add(new Question("Ткать", "weave, wove, woven", "recast, recast, recast", "dare, durst, dared", "bespeak, bespoke, bespoke", 1));
            questionList.add(new Question("Опрокинуть, огорчить", "rive, rived, riven", "upset, upset, upset", "ken, kenned, kenned", "bet, bet, bet", 2));
            questionList.add(new Question("Развертывать", "fling, flung, flung", "knit,  knit, knit", "unwind, unwound, unwound", "bestride, bestrode, bestridden", 3));
            questionList.add(new Question("Вздуться", "lead, led, led", "swell, swelled, swollen", "broadcast, broadcast, broadcast", "befall, befell, befallen", 2));
            questionList.add(new Question("Ужалить", "sting, stung, stung", "gainsay, gainsaid, gainsaid", "bid, bad, bid", "backslide, backslid, backslid", 1));
        }
        if (level_id == 6) {
            questionList.add(new Question("Клеветать", "backbite, backbitten, backbitten", "overtake, overtook, overtaken", "plead, pleaded, pleaded", "kneel, knelt, knelt", 1));
            questionList.add(new Question("Осаждать", "overcome, overcame, overcome", "override, overrode, overridden", "beset, beset, beset", "overthrow, overthrew, overthrown", 3));
            questionList.add(new Question("Запугивать", "miscast, miscast, miscast", "resell, resold, resold", "browbeat, browbeat, browbeaten", "rebuild, rebuilt, rebuilt", 3));
            questionList.add(new Question("Зенковать", "misspend, misspent, misspent", "oversee, oversaw, overseen", "spread, spread, spread", "countersink, countersank, countersunk", 4));
            questionList.add(new Question("Кукарекать", "overlay, overlaid, overlaid", "crow, crowed, crowed", "stave, staved, staved", "spotlight, spotlit, spotlit", 2));
            questionList.add(new Question("Обитать, задерживаться", "shrive, shrove, shriven", "overshoot, overshot, overshot", "dwell, dwelt, dwelt", "recast, recast, recast", 3));
            questionList.add(new Question("Бежать, спасаться", "overdraw, overdrew, overdrawn", "flee, fled, fled", "strew, strewed, strewn", "repay, repaid, repaid", 2));
            questionList.add(new Question("Позолотить", "gild, gilt, gilt", "underwrite, underwrote, underwritten", "overthrow, overthrew, overthrown", "redo, redid, redone", 1));
            questionList.add(new Question("Гравировать", "overfly, overflew, overflown", "rebuild, rebuilt, rebuilt", "unfreeze, unfroze, unfrozen", "grave, graved, graved", 4));
            questionList.add(new Question("Рубить, тесать", "resell, resold, resold", "stink, stank, stunk", "hew, hewed, hewed", "oversee, oversaw, overseen", 3));
            questionList.add(new Question("Становиться на колени", "beset, beset, beset", "thrive, throve, thriven", "override, overrode, overridden", "kneel, knelt, knelt", 4));
            questionList.add(new Question("Неправильно распределять роли", "miscast, miscast, miscast", "tread, trod, trod", "overlay, overlaid, overlaid", "uphold, upheld, upheld", 1));
            questionList.add(new Question("Неправильно истолковывать", "countersink, countersank, countersunk", "misread, misread, misread", "unsay, unsaid, unsaid", "spring, sprang, sprung", 2));
            questionList.add(new Question("Экономить", "spread, spread, spread", "misspend, misspent, misspent", "overshoot, overshot, overshot", "rewrite, rewrote, rewritten", 2));
            questionList.add(new Question("Преодолевать", "strew, strewed, strewn", "backbite, backbitten, backbitten", "overcome, overcame, overcome", "overtake, overtook, overtaken", 3));
            questionList.add(new Question("Превышать", "crow, crowed, crowed", "gild, gilt, gilt", "withhold, withheld, withheld", "overdraw, overdrew, overdrawn", 4));
            questionList.add(new Question("Объедаться", "browbeat, browbeat, browbeaten", "recast, recast, recast", "repay, repaid, repaid", "overeat, overate, overeaten", 4));
            questionList.add(new Question("Перелетать", "overfly, overflew, overflown", "grave, graved, graved", "spotlight, spotlit, spotlit", "plead, pleaded, pleaded", 1));
            questionList.add(new Question("Нависать", "overhang, overhung, overhung", "rebuild, rebuilt, rebuilt", "countersink, countersank, countersunk", "unsay, unsaid, unsaid", 1));
            questionList.add(new Question("Покрывать", "dwell, dwelt, dwelt", "miscast, miscast, miscast", "overlay, overlaid, overlaid", "gild, gilt, gilt", 3));
            questionList.add(new Question("Отвергать, отклонять", "stave, staved, staved", "override, overrode, overridden", "misspend, misspent, misspent", "shrive, shrove, shriven", 2));
            questionList.add(new Question("Надзирать за", "hew, hewed, hewed", "redo, redid, redone", "misread, misread, misread", "oversee, oversaw, overseen", 4));
            questionList.add(new Question("Расстрелять", "overshoot, overshot, overshot", "overhang, overhung, overhung", "browbeat, browbeat, browbeaten", "stink, stank, stunk", 1));
            questionList.add(new Question("Догонять", "spring, sprang, sprung", "overtake, overtook, overtaken", "beset, beset, beset", "thrive, throve, thriven", 2));
            questionList.add(new Question("Свергать", "overdraw, overdrew, overdrawn", "overeat, overate, overeaten", "overthrow, overthrew, overthrown", "overcome, overcame, overcome", 3));
            questionList.add(new Question("Обращаться к суду", "plead, pleaded, pleaded", "spread, spread, spread", "crow, crowed, crowed", "unfreeze, unfroze, unfrozen", 1));
            questionList.add(new Question("Перестроить", "gild, gilt, gilt", "stink, stank, stunk", "backbite, backbitten, backbitten", "rebuild, rebuilt, rebuilt", 4));
            questionList.add(new Question("Видоизменять, преобразовывать", "uphold, upheld, upheld", "recast, recast, recast", "tread, trod, trod", "underwrite, underwrote, underwritten", 2));
            questionList.add(new Question("Повторять сделанное", "grave, graved, graved", "redo, redid, redone", "withhold, withheld, withheld", "strew, strewed, strewn", 2));
            questionList.add(new Question("Отдавать долг", "repay, repaid, repaid", "thrive, throve, thriven", "dwell, dwelt, dwelt", "overhang, overhung, overhung", 1));
            questionList.add(new Question("Перепродавать", "misread, misread, misread", "resell, resold, resold", "overfly, overflew, overflown", "overdraw, overdrew, overdrawn", 2));
            questionList.add(new Question("Исповедовать", "flee, fled, fled", "unsay, unsaid, unsaid", "hew, hewed, hewed", "shrive, shrove, shriven", 4));
            questionList.add(new Question("Осветить", "overcome, overcame, overcome", "kneel, knelt, knelt", "tread, trod, trod", "spotlight, spotlit, spotlit", 4));
            questionList.add(new Question("Распространяться", "spread, spread, spread", "unfreeze, unfroze, unfrozen", "oversee, oversaw, overseen", "overtake, overtook, overtaken", 1));
            questionList.add(new Question("Скакать, пружинить", "spring, sprang, sprung", "overshoot, overshot, overshot", "miscast, miscast, miscast", "overfly, overflew, overflown", 1));
            questionList.add(new Question("Проламывать, разбивать", "underwrite, underwrote, underwritten", "stave, staved, staved", "grave, graved, graved", "misspend, misspent, misspent", 2));
            questionList.add(new Question("Вонять", "stink, stank, stunk", "recast, recast, recast", "overeat, overate, overeaten", "uphold, upheld, upheld", 1));
            questionList.add(new Question("Усеять, устлать", "gild, gilt, gilt", "rebuild, rebuilt, rebuilt", "kneel, knelt, knelt", "strew, strewed, strewn", 4));
            questionList.add(new Question("Процветать", "flee, fled, fled", "thrive, throve, thriven", "overdraw, overdrew, overdrawn", "retell, retold, retold", 2));
            questionList.add(new Question("Ступать", "rewrite, rewrote, rewritten", "hew, hewed, hewed", "tread, trod, trod", "redo, redid, redone", 3));
            questionList.add(new Question("Подписывать", "crow, crowed, crowed", "overthrow, overthrew, overthrown", "underwrite, underwrote, underwritten", "beset, beset, beset", 3));
            questionList.add(new Question("Размораживать", "repay, repaid, repaid", "unfreeze, unfroze, unfrozen", "stave, staved, staved", "misread, misread, misread", 2));
            questionList.add(new Question("Брать назад свои слова", "unsay, unsaid, unsaid", "countersink, countersank, countersunk", "spring, sprang, sprung", "override, overrode, overridden", 1));
            questionList.add(new Question("Поддерживать", "backbite, backbitten, backbitten", "uphold, upheld, upheld", "spread, spread, spread", "overshoot, overshot, overshot", 2));
            questionList.add(new Question("Удерживать", "withhold, withheld, withheld", "shrive, shrove, shriven", "overcome, overcame, overcome", "spotlight, spotlit, spotlit", 1));
            questionList.add(new Question("Переписать", "browbeat, browbeat, browbeaten", "rewrite, rewrote, rewritten", "resell, resold, resold", "overlay, overlaid, overlaid", 2));
            questionList.add(new Question("Пересказывать", "kneel, knelt, knelt", "repay, repaid, repaid", "retell, retold, retold", "miscast, miscast, miscast", 3));
            questionList.add(new Question("Разогнуть", " dwell, dwelt, dwelt", "overtake, overtook, overtaken", "overthrow, overthrew, overthrown", "unbend, unbent, unbent", 4));
            questionList.add(new Question("Платить вперед", "plead, pleaded, pleaded", "overeat, overate, overeaten", "prepay, prepaid, prepaid", "flee, fled, fled", 3));
            questionList.add(new Question("Переплачивать", "overhang, overhung, overhung", "hew, hewed, hewed", "oversee, oversaw, overseen", "overpay, overpaid, overpaid", 4));
        }
        if (level_id == 7) {
            questionList.add(new Question("Становиться", "sleep, slept, slept", "bite, bit, bit", "become, became, become", "see, saw, seen", 3));
            questionList.add(new Question("Ловить", "catch, caught, caught", "lose, lost, lost", "get, got, got", "read, read, read", 1));
            questionList.add(new Question("Принести", "sit, sat, sat", "bring, brought, brought", "run, ran, run", "ride, rode, ridden", 2));
            questionList.add(new Question("Строить", "read, read, read", "build, built, built", "put, put, put", "pay, paid, paid", 2));
            questionList.add(new Question("Мочь, уметь", "make, made, made", "lose, lost, lost", "speak, spoke, spoken", "can, could, been able", 4));
            questionList.add(new Question("Выбрать", "grow, grew, grown", "put, put, put", "choose, chose, chosen", "lose, lost, lost", 3));
            questionList.add(new Question("Кормить", "fight, fought, fought", "feed, fed, fed", "bite, bit, bit", "catch, caught, caught", 2));
            questionList.add(new Question("Падать", "bring, brought, brought", "see, saw, seen", "leave, left, left", "fall, fell, fallen", 4));
            questionList.add(new Question("Сражаться, драться", "fight, fought, fought", "make, made, made", "can, could, been able", "bite, bit, bit", 1));
            questionList.add(new Question("Дать", "pay, paid, paid", "get, got, got", "give, gave, given", "find, found, found", 3));
            questionList.add(new Question("Расти", "build, built, built", "grow, grew, grown", "creep, crept, crept", "bite, bit, bit", 2));
            questionList.add(new Question("Говорить", "say, said, said", "know, knew, known", "read, read, read", "speak, spoke, spoken", 4));
            questionList.add(new Question("Причинить боль", "hurt, hurt, hurt", "fight, fought, fought", "pay, paid, paid", "blow, blew, blown", 1));
            questionList.add(new Question("Оставить", "leave, left, left", "go, went, gone", "bring, brought, brought", "lose, lost, lost", 1));
            questionList.add(new Question("Терять", "grow, grew, grown", "learn, learnt, learnt", "lose, lost, lost", "cut, cut, cut", 3));
            questionList.add(new Question("Делать", "put, put, put", "run, ran, run", "build, built, built", "make, made, made", 4));
            questionList.add(new Question("Платить", "cost, cost, cost", "pay, paid, paid", "buy, bought, bought", "get, got, got", 2));
            questionList.add(new Question("Класть", "read, read, read", "sit, sat, sat", "put, put, put", "sleep, slept, slept", 3));
            questionList.add(new Question("Читать", "grow, grew, grown", "read, read, read", "run, ran, run", "bring, brought, brought", 2));
            questionList.add(new Question("Ездить верхом", "ride, rode, ridden", "go, went, gone", "drive, drove, driven", "come, came, come", 1));
            questionList.add(new Question("Бежать, владеть", "have, had, had", "creep, crept, crept", "pay, paid, paid", "run, ran, run", 4));
            questionList.add(new Question("Сказать", "know, knew, known", "say, said, said", "learn, learnt, learnt", "choose, chose, chosen", 2));
            questionList.add(new Question("Видеть", "see, saw, seen", "blow, blew, blown", "give, gave, given", "hear, heard, heard", 1));
            questionList.add(new Question("Спать", "forget, forgot, forgotten", "fly, flew, flown", "sleep, slept, slept", "draw, drew, drawn", 3));
            questionList.add(new Question("Кусать", "break, broke, broken", "fight, fought, fought", "bite, bit, bit", "grow, grew, grown", 3));
            questionList.add(new Question("Ударить, попасть", "shear, sheared, shorn", "awake, awoke, awoken", "hit, hit, hit", "reset, reset, reset", 3));
            questionList.add(new Question("Подняться", "arise, arose, arisen", "reset, reset, reset", "remake, remade, remade", "stand, stood, stood", 1));
            questionList.add(new Question("Родиться", "hold, held, held", "dig, dug, dug", "bear, bore, born", "breed, bred, bred", 3));
            questionList.add(new Question("Бить", "dive, dived, dived", "steal, stole, stolen", "take, took, taken", "beat, beat, beaten", 4));
            questionList.add(new Question("Дуть", "rise, rose, risen", "blow, blew, blown", "light, lit, lit", "shake, shook, shaken", 2));
            questionList.add(new Question("Выращивать, разводить", "breed, bred, bred", "prove, proved, proved", "leap, leapt, leapt", "awake, awoke, awoken", 1));
            questionList.add(new Question("Жечь, гореть", "burn, burnt, burnt", "seek, sought, sought", "keep, kept, kept", "stand, stood, stood", 1));
            questionList.add(new Question("Копать", "lie, lay, lain", "dig, dug, dug", "work, worked, worked", "hold, held, held", 2));
            questionList.add(new Question("Нырять, погружаться", "set, set, set", "tell, told, told", "dive, dived, dived", "forecast, forecast, forecast", 3));
            questionList.add(new Question("Грезить, мечтать", "sew, sewed, sewed", "quit, quit, quit", "win, won, won", "dream, dreamt, dreamt", 4));
            questionList.add(new Question("Простить", "forget, forgot, forgotten", "forgive, forgave, forgiven", "take, took, taken", "think, thought, thought", 2));
            questionList.add(new Question("Замерзнуть, замораживать", "wear, wore, worn", "seek, sought, sought", "swim, swam, swum", "freeze, froze, frozen", 4));
            questionList.add(new Question("Висеть, повесить", "hang, hung, hung", "hold, held, held", "shake, shook, shaken", "sell, sold, sold", 1));
            questionList.add(new Question("Прятать", "teach, taught, taught", "light, lit, lit", "hide, hid, hidden", "shear, sheared, shorn", 3));
            questionList.add(new Question("Держать", "stand, stood, stood", "ring, rang, rung", "hold, held, held", "take, took, taken", 3));
            questionList.add(new Question("Вводить (информацию)", "dig, dug, dug", "input, input, input", "tell, told, told", "win, won, won", 2));
            questionList.add(new Question("Хранить", "keep, kept, kept", "hit, hit, hit", "arise, arose, arisen", "breed, bred, bred", 1));
            questionList.add(new Question("Прыгать", "blow, blew, blown", "leap, leapt, leapt", "beat, beat, beaten", "hang, hung, hung", 2));
            questionList.add(new Question("Лежать", "breed, bred, bred", "burn, burnt, burnt", "lie, lay, lain", "send, sent, sent", 3));
            questionList.add(new Question("Мочь, иметь возможность", "hold, held, held", "dream, dreamt, dreamt", "blow, blew, blown", "may, might, might", 4));
            questionList.add(new Question("Подразумевать", "forgive, forgave, forgiven", "freeze, froze, frozen", "mean, meant, meant", "hold, held, held", 3));
            questionList.add(new Question("Работать", "work, worked, worked", "arise, arose, arisen", "leap, leapt, leapt", "arise, arose, arisen", 1));
            questionList.add(new Question("Выполнять повторно", "hit, hit, hit", "send, sent, sent", "blow, blew, blown", "rerun, reran, rerun", 4));
            questionList.add(new Question("Звонить", "burn, burnt, burnt", "ring, rang, rung", "breed, bred, bred", "teach, taught, taught", 2));
            questionList.add(new Question("Искать", "seek, sought, sought", "beat, beat, beaten", "shave, shaved, shaved", "forgive, forgave, forgiven", 1));
            questionList.add(new Question("Продавать", "ring, rang, rung", "leap, leapt, leapt", "breed, bred, bred", "sell, sold, sold", 4));
            questionList.add(new Question("Устанавливать", "hang, hung, hung", "set, set, set", "hold, held, held", "stand, stood, stood", 2));
            questionList.add(new Question("Послать, отправить", "win, won, won", "shave, shaved, shaved", "send, sent, sent", "blow, blew, blown", 3));
            questionList.add(new Question("Петь", "sing, sang, sung", "dream, dreamt, dreamt", "hit, hit, hit", "ring, rang, rung", 1));
            questionList.add(new Question("Стоять", "teach, taught, taught", "stand, stood, stood", "hang, hung, hung", "forgive, forgave, forgiven", 2));
            questionList.add(new Question("Украсть", "blow, blew, blown", "breed, bred, bred", "arise, arose, arisen", "steal, stole, stolen", 4));
            questionList.add(new Question("Плыть", "freeze, froze, frozen", "breed, bred, bred", "burn, burnt, burnt", "swim, swam, swum", 4));
            questionList.add(new Question("Взять, брать", "take, took, taken", "may, might, might", "hit, hit, hit", "beat, beat, beaten", 1));
            questionList.add(new Question("Учить", "stand, stood, stood", "arise, arose, arisen", "teach, taught, taught", "hold, held, held", 3));
            questionList.add(new Question("Рассказывать, сказать", "beat, beat, beaten", "tell, told, told", "forgive, forgave, forgiven", "dream, dreamt, dreamt", 2));
            questionList.add(new Question("Думать", "think, thought, thought", "hold, held, held", "may, might, might", "arise, arose, arisen", 1));
            questionList.add(new Question("Носить (одежду)", "forgive, forgave, forgiven", "hang, hung, hung", "wear, wore, worn", "breed, bred, bred", 3));
            questionList.add(new Question("Выиграть", "shave, shaved, shaved", "freeze, froze, frozen", "leap, leapt, leapt", "win, won, won", 4));
            questionList.add(new Question("Предсказывать", "forecast, forecast, forecast", "beat, beat, beaten", "hit, hit, hit", "ring, rang, rung", 1));
            questionList.add(new Question("Опереться, прислониться", "breed, bred, bred", "leap, leapt, leapt", "lean, leant, leant", "teach, taught, taught", 3));
            questionList.add(new Question("Светить", " light, lit, lit", "win, won, won", "send, sent, sent", "may, might, might", 1));
            questionList.add(new Question("Доказывать, оказаться", "hold, held, held", "blow, blew, blown", "shave, shaved, shaved", "prove, proved, proved", 4));
            questionList.add(new Question("Покидать, оставлять", "hit, hit, hit", "quit, quit, quit", "may, might, might", "beat, beat, beaten", 2));
            questionList.add(new Question("Возвращать", "reset, reset, reset", "burn, burnt, burnt", "win, won, won", "beat, beat, beaten", 1));
            questionList.add(new Question("Подняться", "breed, bred, bred", "arise, arose, arisen", "breed, bred, bred", "rise, rose, risen", 4));
            questionList.add(new Question("Шить", "beat, beat, beaten", "forgive, forgave, forgiven", "sew, sewed, sewed", "freeze, froze, frozen", 3));
            questionList.add(new Question("Трясти", "burn, burnt, burnt", "shake, shook, shaken", "hang, hung, hung", "blow, blew, blown", 2));
            questionList.add(new Question("Брить", "dream, dreamt, dreamt", "beat, beat, beaten", "shave, shaved, shaved", "breed, bred, bred", 3));
            questionList.add(new Question("Стричь", "hit, hit, hit", "arise, arose, arisen", "shear, sheared, shorn", "hold, held, held", 3));
            questionList.add(new Question("Проснуться", "awake, awoke, awoken", "breed, bred, bred", "forgive, forgave, forgiven", "hang, hung, hung", 1));
            questionList.add(new Question("Пребывать", "bless, blessed, blessed", "rebind, rebound, rebound", "abide, abode, abode", "shine, shone, shone", 3));
            questionList.add(new Question("Порождать", "deal, dealt, dealt", "lay, laid, laid", "beget, begot, begotten", "rid, rid, rid", 3));
            questionList.add(new Question("Опоясывать ", "cleave, clove, cloven", "begird, begirt, begirt", "shoe, shod, shod", "saw, sawed, sawn", 2));
            questionList.add(new Question("Зреть", "forbid, forbad, forbidden", "inset, inset, inset", "behold, beheld, beheld", "spill, spilt, spilt", 3));
            questionList.add(new Question("Гнуть", "bend, bent, bent", "lade, laded, laded", "strike, struck, struck", "shoot, shot, shot", 1));
            questionList.add(new Question("Умолять, упрашивать", "forsake, forsook, forsaken", "shed, shed, shed", "lend, lent, lent", "beseech, besought ,besought", 4));
            questionList.add(new Question("Связать", "bind, bound, bound", "spill, spilt, spilt", "shine, shone, shone", "lay, laid, laid", 1));
            questionList.add(new Question("Кровоточить", "bleed, bled, bled", "abide, abode, abode", "inset, inset, inset", "shut, shut, shut", 1));
            questionList.add(new Question("Благословлять", "forswear, forswore, forsworn ", "bless, blessed, blessed", "begird, begirt, begirt", "show, showed, shown", 2));
            questionList.add(new Question("Рассечь", " grind, ground, ground", "shoot, shot, shot", "cleave, clove, cloven", "shed, shed, shed", 3));
            questionList.add(new Question("Ползти", "creep, crept, crept", "bend, bent, bent", "lade, laded, laded", "smell, smelt, smelt", 1));
            questionList.add(new Question("Иметь дело", "heave, heaved, heaved", "shoe, shod, shod", "rebind, rebound, rebound", "deal, dealt, dealt", 4));
            questionList.add(new Question("Запретить", "lend, lent, lent", "bleed, bled, bled", "forbid, forbad, forbidden", "slide, slid, slid", 3));
            questionList.add(new Question("Покидать", "mow, mowed, mown", "forsake, forsook, forsaken", "saw, sawed, sawn", "stick, stuck, stuck", 2));
            questionList.add(new Question("Отрекаться", "abide, abode, abode", "beget, begot, begotten", "bless, blessed, blessed", "forswear, forswore, forsworn", 4));
            questionList.add(new Question("Точить, молоть", "behold, beheld, beheld", "rid, rid, rid", "spoil, spoilt, spoilt", "grind, ground, ground", 4));
            questionList.add(new Question("Подымать", "begird, begirt, begirt", "cleave, clove, cloven", "heave, heaved, heaved", "smell, smelt, smelt", 3));
            questionList.add(new Question("Вставлять, вкладывать", "inset, inset, inset", "bind, bound, bound", "shed, shed, shed", "strike, struck, struck", 1));
            questionList.add(new Question("Грузить", "lade, laded, laded", "spill, spilt, spilt", "shoot, shot, shot", "shut, shut, shut", 1));
            questionList.add(new Question("Класть, положить", "beseech, besought ,besought", "forsake, forsook, forsaken", "show, showed, shown", "lay, laid, laid", 4));
            questionList.add(new Question("Одолжить", "stick, stuck, stuck", "lend, lent, lent", "bleed, bled, bled", "swear, swore, sworn", 2));
            questionList.add(new Question("Косить", "shoe, shod, shod", "creep, crept, crept", "mow, mowed, mown", "bless, blessed, blessed", 3));
            questionList.add(new Question("Перевязывать", "rebind, rebound, rebound", "deal, dealt, dealt", "bend, bent, bent", "spill, spilt, spilt", 1));
            questionList.add(new Question("Избавлять", "rid, rid, rid", "forswear, forswore, forsworn", "beget, begot, begotten", "spoil, spoilt, spoilt", 1));
            questionList.add(new Question("Пилить", "throw, threw, thrown", "saw, sawed, sawn", "swear, swore, sworn", "lade, laded, laded", 2));
            questionList.add(new Question("Проливать", "shed, shed, shed", "behold, beheld, beheld", "spoil, spoilt, spoilt", "spill, spilt, spilt", 1));
            questionList.add(new Question("Светить, сиять", "smell, smelt, smelt", "forbid, forbad, forbidden", "forsake, forsook, forsaken", "shine, shone, shone", 4));
            questionList.add(new Question("Обувать, подковывать", "strike, struck, struck", "grind, ground, ground", "stick, stuck, stuck", "shoe, shod, shod", 4));
            questionList.add(new Question("Стрелять, давать побеги", "lade, laded, laded", "shoot, shot, shot", "bind, bound, bound", "lend, lent, lent", 2));
            questionList.add(new Question("Показывать", "spill, spilt, spilt", "heave, heaved, heaved", "show, showed, shown", "begird, begirt, begirt", 3));
            questionList.add(new Question("Закрывать", "rebind, rebound, rebound", "beseech, besought ,besought", "shut, shut, shut", "inset, inset, inset", 3));
            questionList.add(new Question("Скользить", " slide, slid, slid", "mow, mowed, mown", "deal, dealt, dealt", "lade, laded, laded", 1));
            questionList.add(new Question("Пахнуть, нюхать", "saw, sawed, sawn", "smell, smelt, smelt", "abide, abode, abode", "forsake, forsook, forsaken", 2));
            questionList.add(new Question("Писать или читать по буквам", "spell, spelt, spell", "swear, swore, sworn", "forswear, forswore, forsworn", "bend, bent, bent", 1));
            questionList.add(new Question("Пролить", "beget, begot, begotten", "spill, spilt, spilt", "forbid, forbad, forbidden", "throw, threw, thrown", 2));
            questionList.add(new Question("Портить", "show, showed, shown", "shine, shone, shone", "creep, crept, crept", "spoil, spoilt, spoilt", 4));
            questionList.add(new Question("Уколоть, приклеить", "lay, laid, laid", "shoot, shot, shot", "shoe, shod, shod", "stick, stuck, stuck", 4));
            questionList.add(new Question("Ударить, бить, бастовать", "shine, shone, shone", "strike, struck, struck", "behold, beheld, beheld", "heave, heaved, heaved", 2));
            questionList.add(new Question("Клясться, браниться", "swear, swore, sworn", "rebind, rebound, rebound", "grind, ground, ground", "cleave, clove, cloven", 1));
            questionList.add(new Question("Рвать", "bless, blessed, blessed", "saw, sawed, sawn", "tear, tore, torn", "bleed, bled, bled", 3));
            questionList.add(new Question("Бросить", "forsake, forsook, forsaken", "throw, threw, thrown", "rid, rid, rid", "bind, bound, bound", 2));
            questionList.add(new Question("Просыпаться, будить", "begird, begirt, begirt", "lade, laded, laded", "wake, woke, woken", "deal, dealt, dealt", 3));
            questionList.add(new Question("Подстерегать", "waylay, waylaid, waylaid", "shed, shed, shed", "beseech, besought ,besought", "mow, mowed, mown", 1));
            questionList.add(new Question("Выдавать замуж", "wed, wed, wed", "heave, heaved, heaved", "inset, inset, inset", "slide, slid, slid", 1));
            questionList.add(new Question("Плакать", "bind, bound, bound", "cleave, clove, cloven", "weep, wept, wept", "beget, begot, begotten", 3));
            questionList.add(new Question("Мочить, увлажнять", "deal, dealt, dealt", "wet, wet, wet", "mow, mowed, mown", "show, showed, shown", 2));
            questionList.add(new Question("Заводить (механизм)", "bend, bent, bent", "wind, wound, wound", "forbid, forbad, forbidden", "creep, crept, crept", 2));
            questionList.add(new Question("Противиться", "withstand, withstood, withstood", "lend, lent, lent", "lay, laid, laid", "rid, rid, rid", 1));
            questionList.add(new Question("Скрутить, сжать", "wring, wrung, wrung", "forswear, forswore, forsworn", "grind, ground, ground", "beseech, besought ,besought", 1));
            questionList.add(new Question("Лишать", "behold, beheld, beheld", "abide, abode, abode", "bleed, bled, bled", "bereave, bereft, bereft", 4));
            questionList.add(new Question("Идти", "do, did, done", "go, went, gone", "beat, beat, beat", "break, broke, broken", 2));
            questionList.add(new Question("Быть", "be, was/were, been", "beat, beat, beat", "go, went, gone", "chose, choose, chosen", 1));
            questionList.add(new Question("Начинать", "blow, blew, blown", "drive, drove, driven", "begin, began, begun", "break, broke, broken", 3));
            questionList.add(new Question("Ломать", "break, broke, broken", "build, built, built", "become, became, become", "burn, burnt, burnt", 1));
            questionList.add(new Question("Покупать", "buy, bought, bought", "find, found, found", "go, went, gone", "brake, broke, broken", 1));
            questionList.add(new Question("Пить, выпить", "be, was/were, been", "drink, drank, drunk", "come, came, come", "chose, choose, chosen", 2));
            questionList.add(new Question("Стоить", "creep, crept, crept", "cut, cut, cut", "cost, cost, cost", "get, got, got", 3));
            questionList.add(new Question("Делать", "do, did, done", "go, went, gone", "drive, drove, driven", "brake, broke, broken", 1));
            questionList.add(new Question("Резать", "drive, drove, driven", "do, did, done", "get, got, got", "cut, cut, cut", 4));
            questionList.add(new Question("Рисовать", "learn, learnt, learnt", "draw, drew, drawn", "write, wrote, written", "fly, flew, flown", 2));
            questionList.add(new Question("Водить", "drive, drove, driven", "meet, met, met", "know, knew, known", "beat, beat, beat", 1));
            questionList.add(new Question("Есть", "hear, heard, heard", "cut, cut, cut", "eat, ate, eaten", "brake, broke, broken", 3));
            questionList.add(new Question("Чувствовать", "feel, felt, felt", "build, built, built", "drink, drank, drunk", "creep, crept, crept", 1));
            questionList.add(new Question("Находить", "find, found, found", "blow, blew, blown", "buy, bought, bought", "meet, met, met", 1));
            questionList.add(new Question("Летать", "forget, forgot, forgotten", "go, went, gone", "meet, met, met", "fly, flew, flown", 4));
            questionList.add(new Question("Забывать", "understand, understood, understood", "forget, forgot, forgotten", "come, came, come", "brake, broke, broken", 2));
            questionList.add(new Question("Получать", "get, got, got", "buy, bought, bought", "hear, heard, heard", "be, was/were, been", 1));
            questionList.add(new Question("Иметь", "write, wrote, written", "meet, met, met", "cut, cut, cut", "have, had, had", 4));
            questionList.add(new Question("Слышать", "build, built, built", "drink, drank, drunk", "hear, heard, heard", "find, found, found", 3));
            questionList.add(new Question("Знать", "know, knew, known", "write, wrote, written", "fly, flew, flown", "brake, broke, broken", 1));
            questionList.add(new Question("Учить", "beat, beat, beat", "learn, learnt, learnt", "chose, choose, chosen", "hear, heard, heard", 2));
            questionList.add(new Question("Встречать", "meet, met, met", "fly, flew, flown", "buy, bought, bought", "write, wrote, written", 1));
            questionList.add(new Question("Писать", "blow, blew, blown", "be, was/were, been", "drink, drank, drunk", "write, wrote, written", 4));
            questionList.add(new Question("Понимать", "forget, forgot, forgotten", "understand, understood, understood", "catch, caught, caught", "know, knew, known", 2));
            questionList.add(new Question("Приходить", "creep, crept, crept", "break,broke, broken", "come, came, come", "forget, forgot, forgotten", 3));
            questionList.add(new Question("Отпадать", "forbear, forbore, forborne", "rive, rived, riven", "backslide, backslid, backslid", "inlay, inlaid, inlaid", 3));
            questionList.add(new Question("Случиться ", "befall, befell, befallen", "gainsay, gainsaid, gainsaid", "partake, partook, partaken", "shred, shred, shred", 1));
            questionList.add(new Question("Лишать", "bereave, bereft, bereft", "interweave, interwove, interwoven", "knit,  knit, knit", "shrink, shrank, shrunk", 1));
            questionList.add(new Question("Заказывать", "rend, rent, rent", "bespeak, bespoke, bespoke", "lead, led, led", "sink, sank, sunk", 2));
            questionList.add(new Question("Садиться, сидеть верхом", "recast, recast, recast ", "bestride, bestrode, bestridden", "smite, smote, smitten", "slink, slunk, slunk", 2));
            questionList.add(new Question("Держать пари", "bet, bet, bet", "sling, slung, slung", "speed, sped, sped", "slay, slew, slain", 1));
            questionList.add(new Question("Велеть, просить", "sow, sowed, sowed", "bid, bad, bid", "let, let , let", "ken, kenned, kenned", 2));
            questionList.add(new Question("Вещать (по ТВ, радио)", "backslide, backslid, backslid", "spit, spat, spat", "stride, strode, stridden", "broadcast, broadcast, broadcast", 4));
            questionList.add(new Question("Разразиться, взорваться", "rive, rived, riven", "recast, recast, recast", "spin, spun, spun", "burst, burst, burst", 4));
            questionList.add(new Question("Разжаловать, уничтожить", "bust, bust, bust", "sink, sank, sunk", "split, split, split", "swing, swung, swung", 1));
            questionList.add(new Question("Бранить", "chide, chid, chid", "lead, led, led", "knit,  knit, knit", "slit, slit, slit", 1));
            questionList.add(new Question("Сметь", "dare, durst, dared", "partake, partook, partaken", "sweep, swept, swept", "thrust, thrust, thrust", 1));
            questionList.add(new Question("Бросить", "shred, shred, shred", "shrink, shrank, shrunk", "rend, rent, rent", "fling, flung, flung", 4));
            questionList.add(new Question("Воздерживаться", "let, let , let", "forbear, forbore, forborne", "sow, sowed, sowed", "speed, sped, sped", 2));
            questionList.add(new Question("Отрицать, противоречить", "gainsay, gainsaid, gainsaid", "bereave, bereft, bereft", "strive, strove, striven", "upset, upset, upset", 1));
            questionList.add(new Question("Опоясывать", "slink, slunk, slunk", "bet, bet, bet", "slay, slew, slain", "gird, girded, girded", 4));
            questionList.add(new Question("Вкладывать, выстилать", "sling, slung, slung", "smite, smote, smitten", "inlay, inlaid, inlaid", "weave, wove, woven", 3));
            questionList.add(new Question("Вплести, воткать", "bespeak, bespoke, bespoke", "interweave, interwove, interwoven", "stride, strode, stridden", "sting, stung, stung", 2));
            questionList.add(new Question("Знать, узнавать по виду", "ken, kenned, kenned", "string, strung, strung", "swing, swung, swung", "sow, sowed, sowed", 1));
            questionList.add(new Question("Вязать", "bestride, bestrode, bestridden", "befall, befell, befallen", "spit, spat, spat", "knit,  knit, knit", 4));
            questionList.add(new Question("Вести", "bid, bad, bid", "chide, chid, chid", "lead, led, led", "split, split, split", 3));
            questionList.add(new Question("Пустить, дать", "slit, slit, slit", "bust, bust, bust", "fling, flung, flung", "let, let , let", 4));
            questionList.add(new Question("Вкушать", "broadcast, broadcast, broadcast", "partake, partook, partaken", "thrust, thrust, thrust", "upset, upset, upset", 2));
            questionList.add(new Question("Видоизменять, преобразовывать", "spin, spun, spun", "recast, recast, recast", "speed, sped, sped", "weave, wove, woven", 2));
            questionList.add(new Question("Раздирать", "rend, rent, rent", "dare, durst, dared", "bereave, bereft, bereft", "sweep, swept, swept", 1));
            questionList.add(new Question("Расщеплять", "rive, rived, riven", "stride, strode, stridden", "gainsay, gainsaid, gainsaid", "string, strung, strung", 1));
            questionList.add(new Question("Кромсать, расползаться", "strive, strove, striven", "shred, shred, shred", "gainsay, gainsaid, gainsaid", "thrust, thrust, thrust", 2));
            questionList.add(new Question("Сокращаться, сжиматься", "smite, smote, smitten", "forbear, forbore, forborne", "shrink, shrank, shrunk", "swing, swung, swung", 3));
            questionList.add(new Question("Тонуть", "sink, sank, sunk", "inlay, inlaid, inlaid", "bet, bet, bet", "spin, spun, spun", 1));
            questionList.add(new Question("Убивать", "speed, sped, sped", "backslide, backslid, backslid", "bust, bust, bust", "slay, slew, slain", 4));
            questionList.add(new Question("Швырять, подвешивать", "sweep, swept, swept", "bestride, bestrode, bestridden", "split, split, split", "sling, slung, slung", 4));
            questionList.add(new Question("Идти крадучись", "string, strung, strung", "broadcast, broadcast, broadcast", "slink, slunk, slunk", "spit, spat, spat", 3));
            questionList.add(new Question("Разрезать (вдоль)", "interweave, interwove, interwoven", "bid, bad, bid", "chide, chid, chid", "slit, slit, slit", 4));
            questionList.add(new Question("Ударять, разбивать", "partake, partook, partaken", "smite, smote, smitten", "bust, bust, bust", "rend, rent, rent", 2));
            questionList.add(new Question("Сеять", "shrink, shrank, shrunk", "shred, shred, shred", "sow, sowed, sowed", "strive, strove, striven", 3));
            questionList.add(new Question("Ускорять, спешить", "speed, sped, sped", "bespeak, bespoke, bespoke", "slay, slew, slain", "gainsay, gainsaid, gainsaid", 1));
            questionList.add(new Question("Прясть", "let, let , let", "spin, spun, spun", "dare, durst, dared", "slit, slit, slit", 2));
            questionList.add(new Question("Плевать", "gainsay, gainsaid, gainsaid", "recast, recast, recast", "sling, slung, slung", "spit, spat, spat", 4));
            questionList.add(new Question("Расщепить", "split, split, split", "rend, rent, rent", "sink, sank, sunk", "bust, bust, bust", 1));
            questionList.add(new Question("Шагать", "stride, strode, stridden", "fling, flung, flung", "befall, befell, befallen", "slink, slunk, slunk", 1));
            questionList.add(new Question("Нанизать, натянуть", "inlay, inlaid, inlaid", "slay, slew, slain", "string, strung, strung", "chide, chid, chid", 3));
            questionList.add(new Question("Стараться", "rive, rived, riven", "strive, strove, striven", "interweave, interwove, interwoven", "bereave, bereft, bereft", 2));
            questionList.add(new Question("Мести, промчаться", "ken, kenned, kenned", "sweep, swept, swept", "shred, shred, shred", "bust, bust, bust", 2));
            questionList.add(new Question("Качаться", "sink, sank, sunk", "shrink, shrank, shrunk", "lead, led, led", "swing, swung, swung", 4));
            questionList.add(new Question("Толкнуть, сунуть", "partake, partook, partaken", "let, let , let", "forbear, forbore, forborne", "thrust, thrust, thrust", 4));
            questionList.add(new Question("Ткать", "weave, wove, woven", "recast, recast, recast", "dare, durst, dared", "bespeak, bespoke, bespoke", 1));
            questionList.add(new Question("Опрокинуть, огорчить", "rive, rived, riven", "upset, upset, upset", "ken, kenned, kenned", "bet, bet, bet", 2));
            questionList.add(new Question("Развертывать", "fling, flung, flung", "knit,  knit, knit", "unwind, unwound, unwound", "bestride, bestrode, bestridden", 3));
            questionList.add(new Question("Вздуться", "lead, led, led", "swell, swelled, swollen", "broadcast, broadcast, broadcast", "befall, befell, befallen", 2));
            questionList.add(new Question("Ужалить", "sting, stung, stung", "gainsay, gainsaid, gainsaid", "bid, bad, bid", "backslide, backslid, backslid", 1));
            questionList.add(new Question("Клеветать", "backbite, backbitten, backbitten", "overtake, overtook, overtaken", "plead, pleaded, pleaded", "kneel, knelt, knelt", 1));
            questionList.add(new Question("Осаждать", "overcome, overcame, overcome", "override, overrode, overridden", "beset, beset, beset", "overthrow, overthrew, overthrown", 3));
            questionList.add(new Question("Запугивать", "miscast, miscast, miscast", "resell, resold, resold", "browbeat, browbeat, browbeaten", "rebuild, rebuilt, rebuilt", 3));
            questionList.add(new Question("Зенковать", "misspend, misspent, misspent", "oversee, oversaw, overseen", "spread, spread, spread", "countersink, countersank, countersunk", 4));
            questionList.add(new Question("Кукарекать", "overlay, overlaid, overlaid", "crow, crowed, crowed", "stave, staved, staved", "spotlight, spotlit, spotlit", 2));
            questionList.add(new Question("Обитать, задерживаться", "shrive, shrove, shriven", "overshoot, overshot, overshot", "dwell, dwelt, dwelt", "recast, recast, recast", 3));
            questionList.add(new Question("Бежать, спасаться", "overdraw, overdrew, overdrawn", "flee, fled, fled", "strew, strewed, strewn", "repay, repaid, repaid", 2));
            questionList.add(new Question("Позолотить", "gild, gilt, gilt", "underwrite, underwrote, underwritten", "overthrow, overthrew, overthrown", "redo, redid, redone", 1));
            questionList.add(new Question("Гравировать", "overfly, overflew, overflown", "rebuild, rebuilt, rebuilt", "unfreeze, unfroze, unfrozen", "grave, graved, graved", 4));
            questionList.add(new Question("Рубить, тесать", "resell, resold, resold", "stink, stank, stunk", "hew, hewed, hewed", "oversee, oversaw, overseen", 3));
            questionList.add(new Question("Становиться на колени", "beset, beset, beset", "thrive, throve, thriven", "override, overrode, overridden", "kneel, knelt, knelt", 4));
            questionList.add(new Question("Неправильно распределять роли", "miscast, miscast, miscast", "tread, trod, trod", "overlay, overlaid, overlaid", "uphold, upheld, upheld", 1));
            questionList.add(new Question("Неправильно истолковывать", "countersink, countersank, countersunk", "misread, misread, misread", "unsay, unsaid, unsaid", "spring, sprang, sprung", 2));
            questionList.add(new Question("Экономить", "spread, spread, spread", "misspend, misspent, misspent", "overshoot, overshot, overshot", "rewrite, rewrote, rewritten", 2));
            questionList.add(new Question("Преодолевать", "strew, strewed, strewn", "backbite, backbitten, backbitten", "overcome, overcame, overcome", "overtake, overtook, overtaken", 3));
            questionList.add(new Question("Превышать", "crow, crowed, crowed", "gild, gilt, gilt", "withhold, withheld, withheld", "overdraw, overdrew, overdrawn", 4));
            questionList.add(new Question("Объедаться", "browbeat, browbeat, browbeaten", "recast, recast, recast", "repay, repaid, repaid", "overeat, overate, overeaten", 4));
            questionList.add(new Question("Перелетать", "overfly, overflew, overflown", "grave, graved, graved", "spotlight, spotlit, spotlit", "plead, pleaded, pleaded", 1));
            questionList.add(new Question("Нависать", "overhang, overhung, overhung", "rebuild, rebuilt, rebuilt", "countersink, countersank, countersunk", "unsay, unsaid, unsaid", 1));
            questionList.add(new Question("Покрывать", "dwell, dwelt, dwelt", "miscast, miscast, miscast", "overlay, overlaid, overlaid", "gild, gilt, gilt", 3));
            questionList.add(new Question("Отвергать, отклонять", "stave, staved, staved", "override, overrode, overridden", "misspend, misspent, misspent", "shrive, shrove, shriven", 2));
            questionList.add(new Question("Надзирать за", "hew, hewed, hewed", "redo, redid, redone", "misread, misread, misread", "oversee, oversaw, overseen", 4));
            questionList.add(new Question("Расстрелять", "overshoot, overshot, overshot", "overhang, overhung, overhung", "browbeat, browbeat, browbeaten", "stink, stank, stunk", 1));
            questionList.add(new Question("Догонять", "spring, sprang, sprung", "overtake, overtook, overtaken", "beset, beset, beset", "thrive, throve, thriven", 2));
            questionList.add(new Question("Свергать", "overdraw, overdrew, overdrawn", "overeat, overate, overeaten", "overthrow, overthrew, overthrown", "overcome, overcame, overcome", 3));
            questionList.add(new Question("Обращаться к суду", "plead, pleaded, pleaded", "spread, spread, spread", "crow, crowed, crowed", "unfreeze, unfroze, unfrozen", 1));
            questionList.add(new Question("Перестроить", "gild, gilt, gilt", "stink, stank, stunk", "backbite, backbitten, backbitten", "rebuild, rebuilt, rebuilt", 4));
            questionList.add(new Question("Видоизменять, преобразовывать", "uphold, upheld, upheld", "recast, recast, recast", "tread, trod, trod", "underwrite, underwrote, underwritten", 2));
            questionList.add(new Question("Повторять сделанное", "grave, graved, graved", "redo, redid, redone", "withhold, withheld, withheld", "strew, strewed, strewn", 2));
            questionList.add(new Question("Отдавать долг", "repay, repaid, repaid", "thrive, throve, thriven", "dwell, dwelt, dwelt", "overhang, overhung, overhung", 1));
            questionList.add(new Question("Перепродавать", "misread, misread, misread", "resell, resold, resold", "overfly, overflew, overflown", "overdraw, overdrew, overdrawn", 2));
            questionList.add(new Question("Исповедовать", "flee, fled, fled", "unsay, unsaid, unsaid", "hew, hewed, hewed", "shrive, shrove, shriven", 4));
            questionList.add(new Question("Осветить", "overcome, overcame, overcome", "kneel, knelt, knelt", "tread, trod, trod", "spotlight, spotlit, spotlit", 4));
            questionList.add(new Question("Распространяться", "spread, spread, spread", "unfreeze, unfroze, unfrozen", "oversee, oversaw, overseen", "overtake, overtook, overtaken", 1));
            questionList.add(new Question("Скакать, пружинить", "spring, sprang, sprung", "overshoot, overshot, overshot", "miscast, miscast, miscast", "overfly, overflew, overflown", 1));
            questionList.add(new Question("Проламывать, разбивать", "underwrite, underwrote, underwritten", "stave, staved, staved", "grave, graved, graved", "misspend, misspent, misspent", 2));
            questionList.add(new Question("Вонять", "stink, stank, stunk", "recast, recast, recast", "overeat, overate, overeaten", "uphold, upheld, upheld", 1));
            questionList.add(new Question("Усеять, устлать", "gild, gilt, gilt", "rebuild, rebuilt, rebuilt", "kneel, knelt, knelt", "strew, strewed, strewn", 4));
            questionList.add(new Question("Процветать", "flee, fled, fled", "thrive, throve, thriven", "overdraw, overdrew, overdrawn", "retell, retold, retold", 2));
            questionList.add(new Question("Ступать", "rewrite, rewrote, rewritten", "hew, hewed, hewed", "tread, trod, trod", "redo, redid, redone", 3));
            questionList.add(new Question("Подписывать", "crow, crowed, crowed", "overthrow, overthrew, overthrown", "underwrite, underwrote, underwritten", "beset, beset, beset", 3));
            questionList.add(new Question("Размораживать", "repay, repaid, repaid", "unfreeze, unfroze, unfrozen", "stave, staved, staved", "misread, misread, misread", 2));
            questionList.add(new Question("Брать назад свои слова", "unsay, unsaid, unsaid", "countersink, countersank, countersunk", "spring, sprang, sprung", "override, overrode, overridden", 1));
            questionList.add(new Question("Поддерживать", "backbite, backbitten, backbitten", "uphold, upheld, upheld", "spread, spread, spread", "overshoot, overshot, overshot", 2));
            questionList.add(new Question("Удерживать", "withhold, withheld, withheld", "shrive, shrove, shriven", "overcome, overcame, overcome", "spotlight, spotlit, spotlit", 1));
            questionList.add(new Question("Переписать", "browbeat, browbeat, browbeaten", "rewrite, rewrote, rewritten", "resell, resold, resold", "overlay, overlaid, overlaid", 2));
            questionList.add(new Question("Пересказывать", "kneel, knelt, knelt", "repay, repaid, repaid", "retell, retold, retold", "miscast, miscast, miscast", 3));
            questionList.add(new Question("Разогнуть", " dwell, dwelt, dwelt", "overtake, overtook, overtaken", "overthrow, overthrew, overthrown", "unbend, unbent, unbent", 4));
            questionList.add(new Question("Платить вперед", "plead, pleaded, pleaded", "overeat, overate, overeaten", "prepay, prepaid, prepaid", "flee, fled, fled", 3));
            questionList.add(new Question("Переплачивать", "overhang, overhung, overhung", "hew, hewed, hewed", "oversee, oversaw, overseen", "overpay, overpaid, overpaid", 4));
        }
        if (level_id == 8) {
            questionList.add(new Question("Освещать фото контражурным свечением", "backlight, backlit, backlighted", "gin, gan, gunnen", "wont, wont, wont(ed)", "hand-set, hand-set, hand-set", 1));
            questionList.add(new Question("Называть, величать", "bestead, besteaded, bested", "bename, benamed, benempt", "wont, wont, wont(ed)", "wicket-keep, wicket-kept, wicket-kept", 2));
            questionList.add(new Question("Быть полезным", "hent, hent, hent", "wiredraw, wiredrew, wiredrawn", "bestead, besteaded, bested", "bename, benamed, benempt", 3));
            questionList.add(new Question("Начинать", "wont, wont, wont(ed)", "wiredraw, wiredrew, wiredrawn", "ken, kent, kenned", "gin, gan, gunnen", 4));
            questionList.add(new Question("Набирать вручную", "hand-set, hand-set, hand-set", "backlight, backlit, backlighted", "bename, benamed, benempt", "shrive, shrove, shriven", 1));
            questionList.add(new Question("Схватывать, охватывать", "ken, kent, kenned", "hent, hent, hent", "bename, benamed, benempt", "wiredraw, wiredrew, wiredrawn", 2));
            questionList.add(new Question("Знать, иметь познания", "wont, wont, wont(ed)", "bestead, besteaded, bested", "ken, kent, kenned", "gin, gan, gunnen", 3));
            questionList.add(new Question("Охранять воротца (в крикете)", "hent, hent, hent", "backlight, backlit, backlighted", "hand-set, hand-set, hand-set", "wicket-keep, wicket-kept, wicket-kept", 4));
            questionList.add(new Question("Иметь обыкновение", "bename, benamed, benempt", "wont, wont, wont(ed)", "gin, gan, gunnen", "bestead, besteaded, bested", 2));
            questionList.add(new Question("Тех. волочить проволоку", "wicket-keep, wicket-kept, wicket-kept", "ken, kent, kenned", "wiredraw, wiredrew, wiredrawn", "hent, hent, hent", 3));

        }
        Random random = new Random();
        int randomNum = random.nextInt(questionList.size());
        questionList.get(randomNum);
        Collections.shuffle(questionList);
        setQuestion();
    }

    private void setQuestion() {
        questionLabel.setText(questionList.get(0).getQuestion());
        answer1.setText(questionList.get(0).getAnswerA());
        answer2.setText(questionList.get(0).getAnswerB());
        answer3.setText(questionList.get(0).getAnswerC());
        answer4.setText(questionList.get(0).getAnswerD());

        qCount.setText(String.valueOf(1) + "/" + String.valueOf(questionList.size()));
        rAns = 1;
        wAns = 1;
        quesNum = 0;
    }

    //Обработка возвратной кнопки в title
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        int selectedOption = 0;

        switch (v.getId()) {

            case R.id.answer1:
                selectedOption = 1;
                break;

            case R.id.answer2:
                selectedOption = 2;
                break;

            case R.id.answer3:
                selectedOption = 3;
                break;

            case R.id.answer4:
                selectedOption = 4;
                break;
            default:
        }

        checkAnswer(selectedOption, v);
    }

    private void checkAnswer(int selectedOption, View view) {

        if (selectedOption == questionList.get(quesNum).getCorrectAns()) {
            //Правильный ответ
            ((Button) view).setBackgroundResource(R.drawable.fields_test_right);
            score++;
            tvRightAnswer.setText(String.valueOf(rAns++));

        } else {
            //Wrong answer
            ((Button) view).setBackgroundResource(R.drawable.fields_test_wrong);
            tvWrongAnswer.setText(String.valueOf(wAns++));
            switch (questionList.get(quesNum).getCorrectAns()) {
                case 1:
                    answer1.setBackgroundResource(R.drawable.fields_test_right);
                    break;
                case 2:
                    answer2.setBackgroundResource(R.drawable.fields_test_right);
                    break;
                case 3:
                    answer3.setBackgroundResource(R.drawable.fields_test_right);
                    break;
                case 4:
                    answer4.setBackgroundResource(R.drawable.fields_test_right);
                    break;
                default:
            }
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();
            }
        }, 2000);
    }

    private void changeQuestion() {
        if (quesNum < questionList.size() - 1) {

            quesNum++;

            playAnim(questionLabel, 0, 0);
            playAnim(answer1, 0, 1);
            playAnim(answer2, 0, 2);
            playAnim(answer3, 0, 3);
            playAnim(answer4, 0, 4);

            qCount.setText(String.valueOf(quesNum + 1) + "/" + String.valueOf(questionList.size()));

        } else {
            // Go to Score Activity
            Intent intent = new Intent("ru.max.irvefree.ScoreActivity");
            intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(questionList.size()));
            startActivity(intent);
            finish();
        }
    }

    // Create Animations
    private void playAnim(final View view, final int value, final int viewNum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (value == 0) {
                            switch (viewNum) {
                                case 0:
                                    ((TextView) view).setText(questionList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button) view).setText(questionList.get(quesNum).getAnswerA());
                                    break;
                                case 2:
                                    ((Button) view).setText(questionList.get(quesNum).getAnswerB());
                                    break;
                                case 3:
                                    ((Button) view).setText(questionList.get(quesNum).getAnswerC());
                                    break;
                                case 4:
                                    ((Button) view).setText(questionList.get(quesNum).getAnswerD());
                                    break;
                            }

                            if (viewNum != 0)
                                //  ((Button)view).setBackgroundColor(Color.WHITE);
                                ((Button) view).setBackgroundResource(R.drawable.fields_test);
                            playAnim(view, 1, viewNum);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

}
