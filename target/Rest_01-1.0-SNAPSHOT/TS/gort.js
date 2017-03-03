/**
 * Created by -rom- on 20.02.2017.
 */
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b)
        if (b.hasOwnProperty(p))
            d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var Animal = (function () {
    function Animal(theName) {
        this.name = theName;
    }
    return Animal;
}());
var Snake = (function (_super) {
    __extends(Snake, _super);
    function Snake(name) {
        _super.call(this, name);
    }
    Snake.prototype.move = function (distance) {
        console.log("Slithering");
    };
    return Snake;
}(Animal));
var Fish = (function (_super) {
    __extends(Fish, _super);
    function Fish(name) {
        _super.call(this, name);
    }
    Fish.prototype.move = function (distance) {
        console.log("Swim");
    };
    return Fish;
}(Animal));
var snake = new Snake('snake');
snake.move(5);
