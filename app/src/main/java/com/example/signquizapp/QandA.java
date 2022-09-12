package com.example.signquizapp;

public class QandA {

    public static String[] question = {
            "What's the name of the sign?",
            "Name the sign.",
            "What's the sign's name?",
            "The sign's name is?"
    };

    public static String[][] choices = {
            {"Wrong Way", "Yeild", "Stop", "Go"},
            {"No Turn", "No Right Turn", "No Right", "Right Turn Prohibition"},
            {"School","Crosswalk","Yeild Pedestrians","Pedestrian Traffic"},
            {"Interstate Sign","Interstate Route","Interstate 5","Interstate Marker"}
    };

    public static String[] answers = {
        "Stop",
        "Right Turn Prohibition",
        "School",
        "Interstate Route"
    };

    public static int[] images = {

            R.drawable.stop,
            R.drawable.right_turn_prohibition,
            R.drawable.school,
            R.drawable.interstate_route
    };

}
