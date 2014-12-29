/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Sho3la
 */
public class Research {
    public String name;
    public String content;
    public String tags;
    public Research(String name, String content, String tags)
    {
        this.name = name;
        this.content = content;
        this.tags = tags;
    }
}
