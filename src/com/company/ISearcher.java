package com.company;

/**
 * Created by tailer_d on 23.07.2016.
 */
public interface ISearcher {

    /**
     * Обновляет внутренние структуры данных для последующего быстрого поиска
     *
     * @param classNames        названия классов в проекте
     * @param modificationDates дата модификации класса в формате мс,
     *                          <p>
     *                          прошедших с 1 января 1970 года
     */

    public void refresh(String[] classNames, long[] modificationDates);

    /**
     * Ищет подходящие имена классов
     * <p>
     * Название должно начинаться с start
     *
     * @param start начало имени класса
     * @return массив длины от 0 до 12, имена классов, упорядоченный по дате
     * <p>
     * модификации и лексиграфически.
     */

    public String[] guess(String start);
}
