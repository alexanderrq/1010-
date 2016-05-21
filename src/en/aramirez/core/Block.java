package en.aramirez.core;

/**
 * Created by aramirez on 5/20/16.
 */
public enum Block {
    /**
     * @
     */
    SINGLE,

    /**
     * @
     * @
     */
    VERTICAL2,

    /**
     * @@
     */
    HORIZONTAL2,

    /**
     * @
     * @
     * @
     */
    VERTICAL3,

    /**
     * @@@
     */
    HORIZONTAL3,

    /**
     *  @
     * @@
     */
    RIGHT_UP3,

    /**
     * @
     * @@
     */
    LEFT_UP3,

    /**
     * @@
     *  @
     */
    RIGHT_DOWN3,

    /**
     * @@
     * @
     */
    LEFT_DOWN3,

    /**
     * @@
     * @@
     */
    SQUARE4,

    /**
     * @
     * @
     * @
     * @
     */
    VERTICAL4,

    /**
     * @@@@
     */
    HORIZONTAL4,

    /**
     * @
     * @
     * @
     * @
     * @
     */
    VERTICAL5,

    /**
     * @@@@@
     */
    HORIZONTAL5,

    /**
     *   @
     *   @
     * @@@
     */
    RIGHT_UP5,

    /**
     * @
     * @
     * @@@
     */
    LEFT_UP5,

    /**
     * @@@
     *   @
     *   @
     */
    RIGHT_DOWN5,

    /**
     * @@@
     * @
     * @
     */
    LEFT_DOWN5,

    /**
     * @@@
     * @@@
     * @@@
     */
    SQUARE9;

    public static Block getRandom(){
        return values()[(int) (Math.random() * values().length)];
    }
}
