package org.example;

import java.util.Date;
import java.util.List;
public class Campaign {
   private int id;
    private int discountPercentage;
    private String description;
    private List<Game> games;
    private Date startDate;
    private Date endDate;

    private  boolean isDeleted;

 public Campaign(int id, int discountPercentage, String description, List<Game> games, Date startDate, Date endDate, boolean isDeleted) {
  this.id = id;
  this.discountPercentage = discountPercentage;
  this.description = description;
  this.games = games;
  this.startDate = startDate;
  this.endDate = endDate;
  this.isDeleted = isDeleted;
 }
 public Campaign(){

 }
 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public int getDiscountPercentage() {
  return discountPercentage;
 }

 public void setDiscountPercentage(int discountPercentage) {
  this.discountPercentage = discountPercentage;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public List<Game> getGames() {
  return games;
 }

 public void setGames(List<Game> games) {
  this.games = games;
 }

 public Date getStartDate() {
  return startDate;
 }

 public void setStartDate(Date startDate) {
  this.startDate = startDate;
 }

 public Date getEndDate() {
  return endDate;
 }

 public void setEndDate(Date endDate) {
  this.endDate = endDate;
 }

 public boolean isDeleted() {
  return isDeleted;
 }

 public void setDeleted(boolean deleted) {
  isDeleted = deleted;
 }
}
