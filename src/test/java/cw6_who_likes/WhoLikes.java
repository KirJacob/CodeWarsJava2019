package cw6_who_likes;

public class WhoLikes {
    /*
    likes {} // must be "no one likes this"
    likes {"Peter"} // must be "Peter likes this"
    likes {"Jacob", "Alex"} // must be "Jacob and Alex like this"
    likes {"Max", "John", "Mark"} // must be "Max, John and Mark like this"
    likes {"Alex", "Jacob", "Mark", "Max"} // must be "Alex, Jacob and 2 others like this"
     */

    public static String whoLikesIt(String... names) {
        //Do your magic here
        final String LIKE_THIS = " like this";
        final String LIKES_THIS = " likes this";
        final String OTHERS = " others";
        final String NO_ONE = "no one likes this";

        int sizeNames = names.length;
        String result = "";
        switch (sizeNames){
            case 0:
                result = NO_ONE;
                break;
            case 1:
                result = names[0] + LIKES_THIS;
                break;
            case 2:
                result = String.format("%s and %s" + LIKE_THIS, names[0], names[1]);
                break;
            case 3:
                result = String.format("%s, %s and %s" + LIKE_THIS, names[0], names[1], names[2]);
                break;
            default:
                result = String.format("%s, %s and %s" + OTHERS + LIKE_THIS, names[0], names[1], names.length - 2);
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(whoLikesIt("Peter"));
        System.out.println(whoLikesIt("Peter1", "Peter2"));
        System.out.println(whoLikesIt("Peter1", "Peter2", "Peter3"));
        System.out.println(whoLikesIt("Peter1", "Peter2", "Peter3", "Peter4"));
    }
}
