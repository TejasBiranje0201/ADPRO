package com.adpro.service;

import java.util.List;

import com.adpro.entity.WorkSchedule;

public interface WorkScheduleService {
List<WorkSchedule>list();
WorkSchedule geyById(int id);
WorkSchedule save(WorkSchedule workSchedule);
void deleteById(int id);
}
