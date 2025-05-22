The stopPropagation() method prevents propagation of the same event from being called. Propagation means bubbling up to parent elements or capturing down to child elements.

* When i click the button it, two events shows:
   * when i click a button, it shows a two alerts initally.
   * after i uncomment the event.stopPropagation(), it shows one alert because the event doest not propagate to the container.