package com.example.kbc_new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Question> questionListAll = new ArrayList<>();

    RecyclerView recycler_options;

    int questionCount = 1;

    int correctAnswerCount = 0;
    int wrongAnswerCount = 0;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.kbc_voice);
        mediaPlayer.start();

        recycler_options = findViewById(R.id.recycler_options);
        recycler_options.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        setQuestionData();
        setQuestion(questionCount - 1);

        findViewById(R.id.btn_next).setOnClickListener(view -> {

            int index = questionCount - 1;

            for (int i = 0; i < questionListAll.get(index).getOptionList().size(); i++) {
                if (questionListAll.get(index).getOptionList().get(i).isCheck()) {
                    questionListAll.get(index).setGiveOption(
                            questionListAll.get(index).getOptionList().get(i).getId());
                }
            }

            if (questionCount == questionListAll.size()) {
                correctAnswerCount = 0;
                wrongAnswerCount = 0;
                for (int i = 0; i < questionListAll.size(); i++) {
                    if (questionListAll.get(i).getCorrectOption() == questionListAll.get(i).getGiveOption()) {
                        if (correctAnswerCount <= questionListAll.size())
                            correctAnswerCount++;
                    } else {
                        if (wrongAnswerCount <= questionListAll.size())
                            wrongAnswerCount++;
                    }
                }

                String result = correctAnswerCount + "/" + questionListAll.size();
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("name", getIntent().getExtras().getString("name"));
                intent.putExtra("email", getIntent().getExtras().getString("email"));
                intent.putExtra("result", result);
                startActivity(intent);

            }

            if (questionCount < questionListAll.size()) {
                questionCount++;
                setQuestion(questionCount - 1);
            }

        });


        findViewById(R.id.btn_previous).setOnClickListener(view -> {
            int index = questionCount - 1;

            for (int i = 0; i < questionListAll.get(index).getOptionList().size(); i++) {
                if (questionListAll.get(index).getOptionList().get(i).isCheck()) {
                    questionListAll.get(index).setGiveOption(
                            questionListAll.get(index).getOptionList().get(i).getId());
                }
            }

            if (questionCount != 0) {
                questionCount--;
                setQuestion(questionCount - 1);
            } else {
                Toast.makeText(this, "You are in first Question", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void setQuestion(int index) {
        TextView tv_question = findViewById(R.id.tv_question);
        tv_question.setText(questionListAll.get(index).getQuestionText());
        setOptionAdapter(questionListAll.get(index).getOptionList());
    }

    private void setOptionAdapter(List<Option> optionList) {
        OptionsAdapter adapter = new OptionsAdapter(this, optionList);
        recycler_options.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setQuestionData() {
        Option option;
        List<Option> optionList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            option = new Option(i, "Q1 Option " + i, false);
            optionList.add(option);
        }
        Question question = new Question(1, "Q1", optionList, 2);
        questionListAll.add(question);

        List<Option> optionList2 = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            option = new Option(i, "Q2 Option " + i, false);
            optionList2.add(option);
        }
        Question question2 = new Question(1, "Q2", optionList2, 2);
        questionListAll.add(question2);

    }

}