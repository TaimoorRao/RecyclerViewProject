package com.example.recyclerviewproject;

/**
 * ExampleItem Class creation
 * Here the value of items are get and set
 */
public class ExampleItem {
    private int mImageResource;
    private String mText1;
    private String mText2;

    /**
     * Constructor
     * @param imageResource
     * @param text1
     * @param text2
     */
    public ExampleItem(int imageResource, String text1, String text2){
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    /**
     * Changing the Text Value when Click on View
     * @param text1
     */
    public void setText1(String text1) { this.mText1 = text1; }

    /**
     * Getter Methods
     * @return
     */
    public int getImageResource() { return mImageResource; }
    public String getText1() { return mText1; }
    public String getText2() { return mText2; }
}
