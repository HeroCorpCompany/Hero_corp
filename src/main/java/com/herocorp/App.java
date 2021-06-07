package com.herocorp;

import com.herocorp.game.Game;

public class App 
{
    public static void main( String[] args )
    {
        Game game = new Game();
        game.run(50);
    }
}
