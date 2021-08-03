package com.murphy.pojo;

import java.util.ArrayList;
import java.util.List;

public class KeshiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KeshiExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andK_idIsNull() {
            addCriterion("k_id is null");
            return (Criteria) this;
        }

        public Criteria andK_idIsNotNull() {
            addCriterion("k_id is not null");
            return (Criteria) this;
        }

        public Criteria andK_idEqualTo(Integer value) {
            addCriterion("k_id =", value, "k_id");
            return (Criteria) this;
        }

        public Criteria andK_idNotEqualTo(Integer value) {
            addCriterion("k_id <>", value, "k_id");
            return (Criteria) this;
        }

        public Criteria andK_idGreaterThan(Integer value) {
            addCriterion("k_id >", value, "k_id");
            return (Criteria) this;
        }

        public Criteria andK_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("k_id >=", value, "k_id");
            return (Criteria) this;
        }

        public Criteria andK_idLessThan(Integer value) {
            addCriterion("k_id <", value, "k_id");
            return (Criteria) this;
        }

        public Criteria andK_idLessThanOrEqualTo(Integer value) {
            addCriterion("k_id <=", value, "k_id");
            return (Criteria) this;
        }

        public Criteria andK_idIn(List<Integer> values) {
            addCriterion("k_id in", values, "k_id");
            return (Criteria) this;
        }

        public Criteria andK_idNotIn(List<Integer> values) {
            addCriterion("k_id not in", values, "k_id");
            return (Criteria) this;
        }

        public Criteria andK_idBetween(Integer value1, Integer value2) {
            addCriterion("k_id between", value1, value2, "k_id");
            return (Criteria) this;
        }

        public Criteria andK_idNotBetween(Integer value1, Integer value2) {
            addCriterion("k_id not between", value1, value2, "k_id");
            return (Criteria) this;
        }

        public Criteria andD_keshiIsNull() {
            addCriterion("d_keshi is null");
            return (Criteria) this;
        }

        public Criteria andD_keshiIsNotNull() {
            addCriterion("d_keshi is not null");
            return (Criteria) this;
        }

        public Criteria andD_keshiEqualTo(String value) {
            addCriterion("d_keshi =", value, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiNotEqualTo(String value) {
            addCriterion("d_keshi <>", value, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiGreaterThan(String value) {
            addCriterion("d_keshi >", value, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiGreaterThanOrEqualTo(String value) {
            addCriterion("d_keshi >=", value, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiLessThan(String value) {
            addCriterion("d_keshi <", value, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiLessThanOrEqualTo(String value) {
            addCriterion("d_keshi <=", value, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiLike(String value) {
            addCriterion("d_keshi like", value, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiNotLike(String value) {
            addCriterion("d_keshi not like", value, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiIn(List<String> values) {
            addCriterion("d_keshi in", values, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiNotIn(List<String> values) {
            addCriterion("d_keshi not in", values, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiBetween(String value1, String value2) {
            addCriterion("d_keshi between", value1, value2, "d_keshi");
            return (Criteria) this;
        }

        public Criteria andD_keshiNotBetween(String value1, String value2) {
            addCriterion("d_keshi not between", value1, value2, "d_keshi");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}