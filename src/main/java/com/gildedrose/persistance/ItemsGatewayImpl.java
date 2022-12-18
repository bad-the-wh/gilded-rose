package com.gildedrose.persistance;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

import com.gildedrose.core.domain.ItemsGateway;
import com.gildedrose.core.domain.item.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

@Getter
@Setter
@Repository
@Transactional
public class ItemsGatewayImpl implements ItemsGateway{

    @PersistenceContext
    private EntityManager em;

    private List<Item> items = new ArrayList<>();

    @Override
    @Transactional
    public List<Item> findItemsBy(){

        Query q = em.createNativeQuery("SELECT * FROM ITEMS ");

        Iterator itr = q.getResultList().iterator();
        while(itr.hasNext()){

            Object[] obj = (Object[]) itr.next();

            if(obj[1].equals("LegendaryItem")){
                items.add(LegendaryItem.builder().id((String) obj[0]).itemName((String) obj[1]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build());
            }
            else if(obj[1].equals("AgingItem")){
                items.add(AgingItem.builder().id((String) obj[0]).itemName((String) obj[1]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build());
            }
            else if(obj[1].equals("EventItem")){
                items.add(EventItem.builder().id((String) obj[0]).itemName((String) obj[1]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build());
            }
            else if(obj[1].equals("ConjuredItem")){
                items.add(ConjuredItem.builder().id((String) obj[0]).itemName((String) obj[1]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build());
            }
            else{
                items.add(GenericItem.builder().id((String) obj[0]).itemName((String) obj[1]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build());
            }

        }

        return items;
    }

    @Override
    @Transactional
    public void saveInventory(List<Item> items) {

        for(Item i : items){

                em.createNativeQuery("INSERT INTO ITEMS (id, name, sellin, quality, base_price) VALUES (?1,?2,?3,?4,?5)")
                        .setParameter(1, i.getId())
                        .setParameter(2, i.getItemName())
                        .setParameter(3, i.getSellIn())
                        .setParameter(4, i.getQuality())
                        .setParameter(5, i.getBasePrice())
                        .executeUpdate();


        }

    }

    @Override
    public Item findItemByItemNameAndQuality(String type, int quality)  {

        Query q = em.createNativeQuery("SELECT * FROM ITEMS  WHERE ITEMS.NAME = ?1 AND ITEMS.QUALITY = ?2", Item.class);
        q.setParameter(1, type);
        q.setParameter(2, quality);
        Iterator itr = q.getResultList().iterator();
        Object[] obj = (Object[]) itr.next();
        if(obj[1] == null){
            return null;
        }
        else if(obj[1] == "LegendaryItem"){
            return LegendaryItem.builder().id((String) obj[0]).itemName((String) obj[2]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build();
        }
        else if(obj[1] == "AgingItem"){
            return AgingItem.builder().id((String) obj[0]).itemName((String) obj[2]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build();
        }
        else if(obj[1] == "EventItem"){
            return EventItem.builder().id((String) obj[0]).itemName((String) obj[2]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build();
        }
        else if(obj[1] == "ConjuredItem"){
            return ConjuredItem.builder().id((String) obj[0]).itemName((String) obj[2]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build();
        }
        else{
            return GenericItem.builder().id((String) obj[0]).itemName((String) obj[2]).sellIn((Integer) obj[2]).quality((Integer) obj[3]).basePrice((Integer) obj[4]).build();
        }
    }

    @Override
    public void deleteItemByBasePrice(String id) {

        em.createNativeQuery("DELETE FROM ITEMS WHERE ID=?1")
                .setParameter(1, id)
                .executeUpdate();

    }


    @Override
    public void updateInventory(Item item) {

        em.createNativeQuery("UPDATE ITEMS SET SELLIN = ?1, QUALITY = ?2 WHERE ID = ?3")
                .setParameter(3, item.getId())
                .setParameter(1, item.getSellIn())
                .setParameter(2, item.getQuality())
                .executeUpdate();

    }


    @Override
    public void flush() {

    }

    @Override
    public <S extends Item> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Item> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Item> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Item getOne(String s) {
        return null;
    }

    @Override
    public Item getById(String s) {
        return null;
    }

    @Override
    public Item getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Item> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Item> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Item> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Item> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Item> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Item> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Item, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Item> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Item> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Item> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public List<Item> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Item entity) {

    }


    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Item> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Item> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Item> findAll(Pageable pageable) {
        return null;
    }

}